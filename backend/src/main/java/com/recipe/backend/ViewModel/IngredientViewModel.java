package com.recipe.backend.ViewModel;
import java.util.Optional;

import com.recipe.backend.Models.Ingredient;

public class IngredientViewModel{

    public IngredientViewModel(){
        
    }

    public IngredientViewModel(Ingredient ingredient){
        Name = ingredient.name;
        Id = ingredient.id;
    }
    
    public IngredientViewModel(Optional<Ingredient> findById) {
        Name = null;
        Id = 0L;
	}

	public Long Id;

    public String Name;
    
    
	public Ingredient convert(IngredientViewModel ingredientViewModel){
        Ingredient ingredient = new Ingredient();
        ingredient.id = ingredientViewModel.Id;
        ingredient.name = ingredientViewModel.Name;
        return ingredient;
    }
}