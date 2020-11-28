package com.beles.services;

import com.beles.commands.RecipeCommand;
import com.beles.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(String id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    RecipeCommand findCommandById(String id);

    void deleteRecipe(String id);


}
