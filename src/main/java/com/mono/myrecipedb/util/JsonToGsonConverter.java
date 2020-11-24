package com.mono.myrecipedb.util;

import com.google.gson.Gson;
import com.mono.myrecipedb.model.recipe.Recipe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class JsonToGsonConverter {

    static Logger log = LogManager.getLogger() ;


    public Recipe readAndConvertJson (String json){
        Recipe importedRecipe = new Recipe();
        //Create a new Gson object
        Gson gson = new Gson();

        //convert the json to  Java object (Recipe)
        importedRecipe = gson.fromJson(json, Recipe.class);

        log.debug(importedRecipe.toString());


        return importedRecipe;
    }



}
