package com.recipe.backend.Controllers;

import com.recipe.backend.Services.FoodDataService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodDataController {
    private final FoodDataService foodDataService;

    FoodDataController(FoodDataService foodDataService) {
        this.foodDataService = foodDataService;
    }

    @GetMapping("/getFoodDataIngredients")
    String all() {
        return foodDataService.findAll();
    }
}