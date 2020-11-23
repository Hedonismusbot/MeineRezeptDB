package com.mono.myrecipedb.service.rest;

import com.mono.myrecipedb.model.recipe.Recipe;
import com.mono.myrecipedb.util.ListContentOfDirectory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService
{
    static Logger log = LogManager.getLogger() ;

    @Override
    public List<String> getAllRecipesFolderNames(String directoryPath) {
        List <String> list =  ListContentOfDirectory.listContent(directoryPath) ;
        return list;
    }

    @Override
    public Recipe findRecipeByPath(String path) {
        return null;
    }

    @Override
    public Recipe findRecipeById(int id) {
        return null;
    }
}
