package com.recipe.backend.ViewModel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodDataSearchViewModel {
    public Integer totalHits;
    public Integer currentPage;
    public Integer totalPages;
    public List<FoodDataIngredient> foods;

}