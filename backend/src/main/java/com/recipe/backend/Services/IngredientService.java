package com.recipe.backend.Services;

import com.recipe.backend.Models.Ingredient;
import com.recipe.backend.Repository.IngredientRepository;

import java.util.ArrayList;
import java.util.List;

import com.recipe.backend.ViewModel.IngredientViewModel;

import org.springframework.stereotype.Service;

@Service
public class IngredientService {
	private final IngredientRepository ingredientRepository;

	IngredientService(IngredientRepository ingredientRepository) {
		this.ingredientRepository = ingredientRepository;
	}

	public List<IngredientViewModel> findAll() {

		List<IngredientViewModel> ingredientViewModels = new ArrayList<>();

		List<Ingredient> ingredients = ingredientRepository.findAll();

		for (Ingredient ingredient : ingredients) {
			ingredientViewModels.add(new IngredientViewModel(ingredient));
		}

		return ingredientViewModels;
	}

	public IngredientViewModel save(IngredientViewModel ingredientViewModel) {

		Ingredient ingredient = ingredientViewModel.convert(ingredientViewModel);
		ingredientViewModel = new IngredientViewModel(ingredientRepository.save(ingredient));
		return ingredientViewModel;

	}

	public IngredientViewModel findById(Long id) throws IllegalArgumentException {
		IngredientViewModel ingredientViewModel = null;
		try {

			if (id != null) {
				ingredientViewModel = new IngredientViewModel(ingredientRepository.findById(id));				
			}
		} catch (Exception e) {
			return null;
		}
		
		return ingredientViewModel;
	}

	public IngredientViewModel update(IngredientViewModel ingredientViewModel) {
		return null;
	}

	public void deleteById(Long id) {
	}

}