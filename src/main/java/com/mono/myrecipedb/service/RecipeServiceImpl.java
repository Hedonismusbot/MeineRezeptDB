package com.mono.myrecipedb.service;

import com.mono.myrecipedb.dao.JsonDAO;
import com.mono.myrecipedb.dao.RecipeSqlLiteDAO;
import com.mono.myrecipedb.model.Recipe;
import com.mono.myrecipedb.util.ListContentOfDirectory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.mono.myrecipedb.MainApplication.RECIPE_DIRECTORY_PATH;

@Service
public class RecipeServiceImpl implements RecipeService
{

    @Autowired // Erzeugt/holt Instanz , dependencyinjection (@Inject geht auch )
    private RecipeSqlLiteDAO sqlLitedao ;
    static Logger log = LogManager.getLogger() ;

    @PostConstruct
    public void init(){
        //ACHTUNG Rezept Ordner wird in Main Klasse festgelegt
       refreshAllRecipesSqlLite(RECIPE_DIRECTORY_PATH);
    }

    @Override
    public List<Recipe> refreshAllRecipesSqlLite(String directoryPath) {
        // Erzeugt Ordner Namensliste (Entspricht -> Pfad/RezeptNamen)
        List <File> listofFolderFiles =  ListContentOfDirectory.listContent(directoryPath) ;
        JsonDAO jdao = new JsonDAO () ;
        List <Recipe> importetRecipeList =  new ArrayList<>();

        deleteAllRecipeSqlLite();

        for ( File folderFile: listofFolderFiles) {
            try {
                Recipe recipe = new Recipe(directoryPath);
                StringBuilder recipefolderPath= new StringBuilder() ;

                recipefolderPath.append("\\").append(folderFile.getName());
                recipe.setFolderPath(recipefolderPath.toString());
                recipe.setName(folderFile.getName());
                recipe.setJson(jdao.importJsonFileToString(recipefolderPath.toString() , folderFile.getName() ));

                sqlLitedao.save(recipe);
                importetRecipeList.add(recipe);
                log.debug("Rezept SQL hinzugefügt: " + recipe.getName());
                log.trace("Daten RezeptSQL \n "+ recipe.toString() );

            } catch (Exception exception) {
                log.error("Rezept SQL NICHT hinzugefügt :  Pfad: " +directoryPath +" Name: "+ folderFile.getName());

            }
        }
        log.info("Rezepte in SqlLite importiert : " + importetRecipeList.size() );

        return importetRecipeList;
    }

    public void deleteAllRecipeSqlLite(){
        sqlLitedao.deleteAll();
        log.debug(" #################    Alle  Rezepte SQL  gelöscht    #################    " );

    }

    @Override
    public List<Recipe> getAllRecipeNamesByFolder(String directoryPath) {
        // Erzeugt Ordner Namensliste (Entspricht -> Pfad/RezeptNamen)
        List <File> listofFolderFiles =  ListContentOfDirectory.listContent(directoryPath) ;
        JsonDAO jdao = new JsonDAO () ;
        List <Recipe> importetRecipeList =  new ArrayList<>();

        for ( File folderFile: listofFolderFiles) {
            try {
                Recipe recipe = new Recipe();
                StringBuilder recipefolderPath= new StringBuilder(directoryPath) ;

                recipefolderPath.append("\\").append(folderFile.getName());
                recipe.setFolderPath(recipefolderPath.toString());
                recipe.setName(folderFile.getName());
                recipe.setJson(jdao.importJsonFileToString(recipefolderPath.toString() , folderFile.getName() ));

                importetRecipeList.add(recipe);
                log.debug("Rezept Ordner gefunden Name: " + recipe.getName());
                log.trace("Rezept Ordner gefunden : "+ recipe.toString() );

            } catch (Exception exception) {
                log.error("Rezept SQL NICHT hinzugefügt :  Pfad: " +directoryPath +" Name: "+ folderFile.getName());
            }
        }
        log.info("Rezepte NICHT in SqlLite importiert aber gefunden in Ordner Anzahl: " + importetRecipeList.size() );

        return importetRecipeList;
    }



    @Override
    public Recipe findRecipeById(int id) {
        JsonDAO jdao = new JsonDAO () ;
        Recipe resultRecipe = sqlLitedao.findById(id);
        log.info(" Gefundenes Rezept Id: " + resultRecipe.getId() + " Name: " + resultRecipe.getName());
        resultRecipe.setJsonDataObject( jdao.convertJsonStringToJavaObject(resultRecipe.getJson()));
        log.trace(" Gefundenes Rezept : " + resultRecipe.toString());
        return resultRecipe;
    }

    @Override
    public List<Recipe> getAllRecipesWithNameContaining(String name) {
        List<Recipe> resultlist = sqlLitedao.findAllByNameContaining(name); // (case insensitiv)
        log.info("Suchanfrage SQL nach Name beinhaltet: '" + name +"'  Ergebnisse gefunden : "+ resultlist.size());
        for (Recipe rez:resultlist) {
            log.debug("Rezept gefunden ID: "+ rez.getId()+
                                    " Name: "+ rez.getName()+
                                    " OrdnerPfad: "+ rez.getFolderPath());
            log.trace(" JsonString : " + rez.getJson());
        }

        return resultlist;
    }

    @Override
    public Recipe save(Recipe newRecipe) {
        log.debug(newRecipe);
        Recipe result = sqlLitedao.save(newRecipe);
        if ( result.getId() != 0 ){
            log.info("Erolgreich gespeichert");

        }
        log.trace(" Gespeichert, antwort Objekt: "+ result);
        return result;
    }
}
