package com.mono.myRecipeDB.service.rest;

import com.mono.myRecipeDB.model.recipe.Recipe;
import com.mono.myRecipeDB.service.rest.RecipeService;
import com.mono.myRecipeDB.util.ListContentOfDirectory;
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
}
