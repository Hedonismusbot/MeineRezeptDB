package com.mono.myrecipedb.controller;


import com.mono.myrecipedb.error.MessageNotFoundException;
import com.mono.myrecipedb.model.RecipeSqlLite;
import com.mono.myrecipedb.model.recipe.Recipe;
import com.mono.myrecipedb.service.RecipeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import static com.mono.myrecipedb.MainApplication.RECIPE_DIRECTORY_PATH;

@RequestMapping
@RestController
public class RecipeController {

    //ACHTUNG Rezept Ordner wird in Main Klasse festgelegt
    public String directoryPath =RECIPE_DIRECTORY_PATH;
    static Logger log = LogManager.getLogger() ;


    @Autowired
    private RecipeService restService;

    @PostConstruct
    public void init(){
        refreshAllRecipes();
    }

    @GetMapping("/recipes")    // http://localhost:8080/recipes
    public List<String> getAllRecipesFolderNames(){
        log.info("/recipes -> aufgerufen , aktueller Rezept Pfad:" + directoryPath);
        List <RecipeSqlLite> list= restService.getAllRecipeNames(directoryPath);
        List <String> result = new ArrayList<>();
        for (RecipeSqlLite recipe : list) {
            log.debug("Result Liste hinzugefügt: Id: "+recipe.getId() +" | Name: " + recipe.getName());
            result.add(recipe.getName());
        }
        return result;
    }

    @GetMapping("/refreshRecipes")    // http://localhost:8080/recipes
    public String refreshAllRecipes(){
        log.info("/refreshRecipes -> aufgerufen , aktueller Rezept Pfad:" + directoryPath);
        List <RecipeSqlLite> list= restService.getAllRecipeNames(directoryPath);
        log.debug("/refreshRecipes -> aufgerufen , Anzahl gefundener Ordner:" + list.size());
        return "Anzahl gefundener Ordner:" + list.size();
    }

    /**
     * Wegen leerzeichen nicht möglich deshalb werden hier alle Rezepte zurückgegebn die
     * das eingegegeben im Namen beinhalten
     */
    @GetMapping("/recipe/recipe-by-Name")  //Hier z.B.:   http://localhost:8080/recipe/recipe-by-Name?name=Spaghetti
    public List<Recipe> getRecipeByName(@RequestParam(name= "name") String path){
        log.info("/recipes/recipe-by-Name/?name=" + path+ " -> aufgerufen , aktueller Rezept Pfad:" + directoryPath);
        List<Recipe> m = restService.getAllRecipesWithNameContaining(path);
        if (m == null){
            throw new MessageNotFoundException("Rezept nicht gefunden: " + path );
        }
        return m;
    }


    @GetMapping("/recipe/{id}") // {Parameter}
    public String getMessageById(@PathVariable("id") int id){

        Recipe resultRecipe = restService.findRecipeById(id);
        log.info("/recipes/" + resultRecipe.getName()+ " -> aufgerufen , aktueller Rezept Pfad:" + resultRecipe.getFolderPath());
        if (resultRecipe == null){
            throw new MessageNotFoundException ("Id nicht vorhanden: " + id );
        }
        return resultRecipe.toString();
    }
}
