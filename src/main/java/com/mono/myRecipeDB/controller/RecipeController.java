package com.mono.myRecipeDB.controller;


import com.mono.myRecipeDB.dao.MySQLLiteDAO;
import com.mono.myRecipeDB.error.MessageNotFoundException;
import com.mono.myRecipeDB.model.RecipeMySQLLite;
import com.mono.myRecipeDB.model.recipe.Recipe;
import com.mono.myRecipeDB.service.rest.RecipeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping
@RestController
public class RecipeController {

    public final String directoryPath = "D:\\Nextcloud\\Rezepte";
    static Logger log = LogManager.getLogger() ;

    @Autowired // Erzeugt/holt Instanz , dependencyinjection (@Inject geht auch )
    private MySQLLiteDAO dao ;
    @Autowired
    private RecipeService restService;

    @GetMapping("/recipes")    // http://localhost:8080/recipes
    public List<String> getAllRecipesFolderNames(){
        log.info("Alle Rezept Ordner Namen hollen von :" + directoryPath);
        List <String> list= restService.getAllRecipesFolderNames(directoryPath);

        for ( String e: list) {

            dao.save(new RecipeMySQLLite(directoryPath+"\\"+ e));
            log.debug("Rezept hinzugefügt: " +directoryPath+"\\"+ e);
        }



        return list;
    }

    @GetMapping("/recipe-by-Name")
    public Recipe getRecipeByName(@RequestParam(name= "path") String path){
        Recipe m = restService.findRecipeByPath(path);
        if (m == null){
            throw new MessageNotFoundException("Rezept nicht gefunden: " + path );
        }
        return m;
    }

}
