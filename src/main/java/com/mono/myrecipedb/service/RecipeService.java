package com.mono.myrecipedb.service;

import com.mono.myrecipedb.model.RecipeSqlLite;
import com.mono.myrecipedb.model.recipe.Recipe;

import java.util.List;

public interface RecipeService {
    void refreshAllRecipes(String directoryPath);
    List<RecipeSqlLite> getAllRecipeNames(String directoryPath);
    Recipe findRecipeById(int id);
    List<Recipe> getAllRecipesWithNameContaining(String name);
}
