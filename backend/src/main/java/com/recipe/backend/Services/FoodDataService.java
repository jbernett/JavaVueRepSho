package com.recipe.backend.Services;

import java.io.IOException;

import org.springframework.stereotype.Service;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.RequestBody;

@Service
public class FoodDataService {

    OkHttpClient client = new OkHttpClient();

    public String findAll() {        

        Request request = new Request.Builder().url("https://api.nal.usda.gov/fdc/v1/foods/list?api_key=9yaQimPviHeHSsrsZ4oqyH7RAa5yvZYrQeJ2Skgo")
                .get().build();

        Response response;
        try {
            response = client.newCall(request).execute();
            String string =  response.body().string();
            return string;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
        
	}
    
}