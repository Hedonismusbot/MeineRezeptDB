package com.mono.myrecipedb.controller;


import com.mono.myrecipedb.error.MessageNotFoundException;
import com.mono.myrecipedb.model.RecipeSqlLite;
import com.mono.myrecipedb.model.recipe.Recipe;
import com.mono.myrecipedb.service.rest.RecipeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping
@RestController
public class RecipeController {

    public String directoryPath = "D:\\Nextcloud\\Rezepte";
    static Logger log = LogManager.getLogger() ;


    @Autowired
    private RecipeService restService;

    @GetMapping("/recipes")    // http://localhost:8080/recipes
    public List<String> getAllRecipesFolderNames(){
        log.info("/recipes -> aufgerufen , aktueller Rezept Pfad:" + directoryPath);
        List <RecipeSqlLite> list= restService.getAllRecipes(directoryPath);
        List <String> result = new ArrayList<>();
        for (RecipeSqlLite recipe : list) {

            result.add(recipe.getName());
        }


        return result;
    }


    @GetMapping("/recipes/recipe-by-Name")
    public Recipe getRecipeByName(@RequestParam(name= "path") String path){
        log.info("/recipes/recipe-by-Name/" + path+ " -> aufgerufen , aktueller Rezept Pfad:" + directoryPath);
        Recipe m = restService.findRecipeByPath(path);
        if (m == null){
            throw new MessageNotFoundException("Rezept nicht gefunden: " + path );
        }
        return m;
    }


    @GetMapping("/recipes/{id}") // {Parameter}
    public Recipe getMessageById(@PathVariable("id") int id){
        log.info("/recipes/" + id+ " -> aufgerufen , aktueller Rezept Pfad:" + directoryPath);
        Recipe m = restService.findRecipeById(id);
        if (m == null){
            throw new MessageNotFoundException ("Id nicht vorhanden: " + id );
        }
        return m;
    }
}
