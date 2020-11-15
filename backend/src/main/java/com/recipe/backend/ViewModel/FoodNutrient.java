package com.recipe.backend.ViewModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodNutrient {
    public Double amount;
    public String derivationCode;
    public String derivationDescription;
    public String name;
    public String number;
    public String unitName;
}