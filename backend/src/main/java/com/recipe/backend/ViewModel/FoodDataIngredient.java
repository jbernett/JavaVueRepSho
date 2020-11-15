package com.recipe.backend.ViewModel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodDataIngredient {
    public String brandOwner;
    public String dataType;
    public String description;
    public Integer fdcId;
    public List<FoodNutrient> foodNutrients;
    public String gtinUpc;
    public String publicationDate;
}