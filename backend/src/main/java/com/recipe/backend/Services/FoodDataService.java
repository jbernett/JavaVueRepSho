package com.recipe.backend.Services;

import org.springframework.stereotype.Service;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recipe.backend.ViewModel.FoodDataIngredient;
import com.recipe.backend.ViewModel.FoodDataSearchViewModel;

@Service
public class FoodDataService {

    private String apiKey = "9yaQimPviHeHSsrsZ4oqyH7RAa5yvZYrQeJ2Skgo";

    public List<FoodDataIngredient> findAll() {
        try {
            JSONObject data = new JSONObject();
            data.put("pageNumber", 1);
            data.put("pageSize", 200);
            List<String> datatype = new ArrayList<String>();
            datatype.add("Branded");
            data.put("dataType", datatype);
            StringBuilder content = createFoodServicePost(data,
                    "https://api.nal.usda.gov/fdc/v1/foods/list?api_key=" + apiKey);

            List<FoodDataIngredient> ingredients = new ObjectMapper().readValue(content.toString(),
                    new TypeReference<List<FoodDataIngredient>>() {
                    });
            return ingredients;
        } catch (Exception e) {
            System.out.println("Error Message");
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
        return null;
    }

    public FoodDataSearchViewModel searchFoodDataIngredients(String term) {
        try {
            JSONObject data = new JSONObject();
            data.put("query", term);
            StringBuilder content = createFoodServicePost(data,
                    "https://api.nal.usda.gov/fdc/v1/foods/search?api_key=" + apiKey);
            FoodDataSearchViewModel ingredients = new ObjectMapper().readValue(content.toString(),
                    new TypeReference<FoodDataSearchViewModel>() {
                    });
            return ingredients;
        } catch (Exception e) {
            System.out.println("Error Message");
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
        return null;
    }

    private StringBuilder createFoodServicePost(JSONObject data, String stringUrl) {
        try {

            URL url = new URL(stringUrl);

            HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type", "application/json");
            httpConnection.setRequestProperty("Accept", "application/json");

            DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
            wr.write(data.toString().getBytes());
            Integer responseCode = httpConnection.getResponseCode();

            BufferedReader bufferedReader;

            if (responseCode > 199 && responseCode < 300) {
                bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
            } else {
                bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
            }

            StringBuilder content = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
            bufferedReader.close();

            return content;

        } catch (Exception e) {
            System.out.println("Error Message");
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
        return null;

    }

}
