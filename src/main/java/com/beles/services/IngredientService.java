package com.beles.services;

import com.beles.commands.IngredientCommand;
import com.beles.domain.Ingredient;
import com.beles.domain.Recipe;

public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(String recipeId, String ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand command);

    void deleteById(String recipeId,String ingredientId);
}
