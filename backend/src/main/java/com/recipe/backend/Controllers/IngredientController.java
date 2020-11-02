package com.recipe.backend.Controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.recipe.backend.Services.IngredientService;
import com.recipe.backend.ViewModel.IngredientViewModel;

@RestController
class IngredientController {

    private final IngredientService ingredientService;

    IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    // Aggregate root

    @GetMapping("/ingredients")
    List<IngredientViewModel> all() {
        return ingredientService.findAll();
    }

    @PostMapping("/ingredients")
    IngredientViewModel newIngredient(@RequestBody IngredientViewModel newIngredient) {
        return ingredientService.save(newIngredient);
    }

    // Single item

    @GetMapping("/ingredients/{id}")
    IngredientViewModel one(@PathVariable Long id) {

        return ingredientService.findById(id);
    }

    @PutMapping("/ingredients/{id}")
    IngredientViewModel updateIngredient(@RequestBody IngredientViewModel ingredient, @PathVariable Long id) {
        return ingredientService.update(ingredient);
    }

    @DeleteMapping("/ingredients/{id}")
    void deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteById(id);
    }
}