package com.mono.myrecipedb.controller;


import com.mono.myrecipedb.error.MessageNotFoundException;
import com.mono.myrecipedb.model.Recipe;
import com.mono.myrecipedb.service.RecipeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import static com.mono.myrecipedb.MainApplication.RECIPE_DIRECTORY_PATH;

@RequestMapping
@RestController
public class RecipeController {


    public String directoryPath = RECIPE_DIRECTORY_PATH;
    static Logger log = LogManager.getLogger();


    @Autowired
    private RecipeService restService;

    @GetMapping("/recipes")    // http://localhost:8080/recipes
    public List<String> getAllRecipesFolderNames() {
        log.info("/recipes -> aufgerufen , aktueller Rezept Pfad:" + directoryPath);
        List<Recipe> list = restService.getAllRecipeNamesByFolder(directoryPath);
        List<String> result = new ArrayList<>();
        for (Recipe recipe : list) {
            log.trace("Result Liste hinzugefügt: Id: " + recipe.getId() + " | Name: " + recipe.getName());
            result.add(recipe.getName());
        }
        log.info("/recipes -> abgearbeitet Rezepte gefunden und hinzugefügt: " + result.size());
        return result;
    }

    @GetMapping("/refreshRecipes")    // http://localhost:8080/refreshRecipes
    public String refreshAllRecipes() {
        log.info("/refreshRecipes -> aufgerufen , aktueller Rezept Pfad:" + directoryPath);
        List<Recipe> result = restService.refreshAllRecipesSqlLite(directoryPath);
        log.info("/refreshRecipes ->  abgearbeitet Rezepte gefunden und hinzugefügt: " + result.size());
        return "Anzahl gefundener Ordner:" + result.size();
    }

    @GetMapping("/deleteAll")    // http://localhost:8080/recipes
    public void deleteAllSqlLiteRecipes() {
        log.info("/deleteAll -> aufgerufen , aktueller Rezept Pfad:" + directoryPath);
        restService.deleteAllRecipeSqlLite();


    }

    /**
     * Wegen leerzeichen nicht möglich deshalb werden hier alle Rezepte zurückgegebn die
     * das eingegegeben im Namen beinhalten (case insensitiv)
     */
    @GetMapping("/recipe/recipe-by-Name")  //Hier z.B.:   http://localhost:8080/recipe/recipe-by-Name?name=Spaghetti
    public List<Recipe> getRecipeByName(@RequestParam(name = "name") String searchName) {
        log.info("/recipes/recipe-by-Name/?name=" + searchName + " -> aufgerufen , aktueller Rezept Pfad:" + directoryPath);
        List<Recipe> m = restService.getAllRecipesWithNameContaining(searchName);
        if (m == null) {
            throw new MessageNotFoundException("Rezept nicht gefunden: " + searchName);

        }
        return m;
    }


    @GetMapping("/recipe/{id}") // {Parameter}
    public String getMessageById(@PathVariable("id") int id) {

        log.info("/recipes/{" +id + "} -> aufgerufen , aktueller Rezept Pfad:" + directoryPath);
        Recipe resultRecipe = restService.findRecipeById(id);
        log.info("/recipes/{" +id + "} -> aufgerufen ,  Rezept gefunden:" +resultRecipe.toString());
        if (resultRecipe == null) {
            throw new MessageNotFoundException("Id nicht vorhanden: " + id);
        }
        return resultRecipe.getJsonDataObject().toString();
    }


    // Post wird verdeckt im Html-Body übertragen
    @PostMapping("/recipe/new-Recipe")    //Hier z.B.:   http://localhost:8080/recipe/new-Recipe
    public Recipe newMessage(@RequestBody Recipe newMessage){

        log.info("/recipe/new-Recipe aufgerufen , aktueller Rezept Pfad:" + directoryPath);
        Recipe resultRecipe = restService.save(newMessage);
        if (resultRecipe == null) {
            throw new MessageNotFoundException("Speichern nicht erfolgreich: ");
        }
        return resultRecipe;
    }

}
