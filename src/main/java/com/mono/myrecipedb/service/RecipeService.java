package com.mono.myrecipedb.service;

import com.mono.myrecipedb.model.Recipe;

import java.util.List;

public interface RecipeService {
    void deleteAllRecipeSqlLite();
    List<Recipe> refreshAllRecipesSqlLite(String directoryPath);
    List<Recipe> getAllRecipeNamesByFolder(String directoryPath);
    Recipe findRecipeById(int id);
    List<Recipe> getAllRecipesWithNameContaining(String name);
    Recipe save (Recipe newRecipe);

}
