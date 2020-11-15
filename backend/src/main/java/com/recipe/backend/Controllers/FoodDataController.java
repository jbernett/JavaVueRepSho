package com.recipe.backend.Controllers;

import java.util.List;

import com.recipe.backend.Services.FoodDataService;
import com.recipe.backend.ViewModel.FoodDataIngredient;
import com.recipe.backend.ViewModel.FoodDataSearchViewModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodDataController {
    private final FoodDataService foodDataService;

    FoodDataController(FoodDataService foodDataService) {
        this.foodDataService = foodDataService;
    }

    @GetMapping("/getFoodDataIngredients")
    List<FoodDataIngredient> all() {
        return foodDataService.findAll();
    }

    @PostMapping("/searchFoodDataIngredients")
    FoodDataSearchViewModel searchFoodDataIngredients(@RequestBody String term) {
        return foodDataService.searchFoodDataIngredients(term);
    }
}