package com.mono.myRecipeDB.service.rest;

import com.mono.myRecipeDB.model.recipe.Recipe;

import java.util.List;

public interface RecipeService {

    List<String> getAllRecipesFolderNames(String directoryPath);

    Recipe findRecipeByPath(String path);
}
