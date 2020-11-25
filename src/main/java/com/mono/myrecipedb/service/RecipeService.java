package com.mono.myrecipedb.service;

import com.mono.myrecipedb.model.RecipeSqlLite;
import com.mono.myrecipedb.model.recipe_schema.Recipe;

import java.util.List;

public interface RecipeService {
    void deleteAllRecipeSqlLite();
    List<RecipeSqlLite> refreshAllRecipesSqlLite(String directoryPath);
    List<RecipeSqlLite> getAllRecipeNamesByFolder(String directoryPath);
    Recipe findRecipeById(int id);
    List<Recipe> getAllRecipesWithNameContaining(String name);
}
