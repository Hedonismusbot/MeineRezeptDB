package com.mono.myrecipedb.service.rest;

import com.mono.myrecipedb.model.RecipeSqlLite;
import com.mono.myrecipedb.model.recipe.Recipe;

import java.util.List;

public interface RecipeService {

    List<RecipeSqlLite> getAllRecipes(String directoryPath);
    Recipe findRecipeByPath(String path);
    Recipe findRecipeById(int id);
}
