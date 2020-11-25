package com.mono.myrecipedb.service;

import com.mono.myrecipedb.dao.JsonDAO;
import com.mono.myrecipedb.dao.RecipeSqlLiteDAO;
import com.mono.myrecipedb.model.RecipeSqlLite;
import com.mono.myrecipedb.model.recipe_schema.Recipe;
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
       refreshAllRecipesSqlLite(RECIPE_DIRECTORY_PATH);
    }

    @Override
    public List<RecipeSqlLite> refreshAllRecipesSqlLite(String directoryPath) {
        // Erzeugt Ordner Namensliste (Entspricht -> Pfad/RezeptNamen)
        List <File> listofFolderFiles =  ListContentOfDirectory.listContent(directoryPath) ;
        JsonDAO jdao = new JsonDAO () ;
        List <RecipeSqlLite> importetRecipeList =  new ArrayList<>();

        deleteAllRecipeSqlLite();

        for ( File folderFile: listofFolderFiles) {
            try {
                StringBuilder recipefolderPath= new StringBuilder() ;
                RecipeSqlLite recipe = new RecipeSqlLite();

                recipefolderPath = recipefolderPath.append(directoryPath).append("\\").append(folderFile.getName());
                recipe.setFolderPath(recipefolderPath.toString());
                recipe.setName(folderFile.getName());
                recipe.setJson(jdao.importJsonFileToString(recipefolderPath.toString() , folderFile.getName() ));
                log.debug("Rezept SQL hinzugefügt: " + recipe.getName());
                log.trace("Daten RezeptSQL \n "+ recipe.toString() );
                sqlLitedao.save(recipe);
                importetRecipeList.add(recipe);

            } catch (Exception exception) {
                log.error("Rezept SQL NICHT hinzugefügt :  Pfad: " +directoryPath +" Name: "+ folderFile.getName());

            }
        }
        log.info("Rezepte in SqlLite importiert : " + importetRecipeList.size() );

        return importetRecipeList;
    }

    public void deleteAllRecipeSqlLite(){
        //TODO Alle SQLdaten löschen fehlerhaft
        sqlLitedao.deleteAll();
        log.debug(" #################      Rezepte SQL alle gelöscht    #################    " );

    }

    @Override
    public List<RecipeSqlLite> getAllRecipeNamesByFolder(String directoryPath) {
        // Erzeugt Ordner Namensliste (Entspricht -> Pfad/RezeptNamen)
        List <File> listofFolderFiles =  ListContentOfDirectory.listContent(directoryPath) ;
        JsonDAO jdao = new JsonDAO () ;
        List <RecipeSqlLite> importetRecipeList =  new ArrayList<>();

        for ( File folderFile: listofFolderFiles) {
            try {
                StringBuilder recipefolderPath= new StringBuilder() ;
                RecipeSqlLite recipe = new RecipeSqlLite();

                recipefolderPath = recipefolderPath.append(directoryPath).append("\\").append(folderFile.getName());
                recipe.setFolderPath(recipefolderPath.toString());
                recipe.setName(folderFile.getName());
                recipe.setJson(jdao.importJsonFileToString(recipefolderPath.toString() , folderFile.getName() ));
                log.debug("Rezept SQL hinzugefügt: " + recipe.getName());
                log.trace("Daten RezeptSQL \n "+ recipe.toString() );
                sqlLitedao.save(recipe);
                importetRecipeList.add(recipe);

            } catch (Exception exception) {
                log.error("Rezept SQL NICHT hinzugefügt :  Pfad: " +directoryPath +" Name: "+ folderFile.getName());
            }
        }
        log.info("Rezepte in SqlLite importiert : " + importetRecipeList.size() );

        return importetRecipeList;
    }



    @Override
    public Recipe findRecipeById(int id) {
        JsonDAO jdao = new JsonDAO () ;
        Recipe resultRecipe = new Recipe();
        RecipeSqlLite resultRecipeSql = sqlLitedao.findById(id);
        resultRecipe = jdao.convertJsonStringToJavaObject(resultRecipeSql.getJson());
        resultRecipe.setsqlLiteId(resultRecipeSql.getId());
        resultRecipe.setFolderPath(resultRecipeSql.getFolderPath());
        return resultRecipe;
    }

    @Override
    public List<Recipe> getAllRecipesWithNameContaining(String name) {
        List<RecipeSqlLite> resultlistSql = sqlLitedao.findAllByNameContaining(name);
        List<Recipe> resultlist = new ArrayList<>();
        log.info("Suchanfrage SQL beinhaltet Name: " + name );
        log.info("Ergebnis Anzahl : "+ resultlistSql.size());
        for (RecipeSqlLite rez:resultlistSql) {

            resultlist.add(new Recipe(rez.getId(), rez.getName()));
            log.info("Rezept gefunden : "+ rez.getName());
            log.trace("Rezept gefunden : "+ rez);
        }

        return resultlist;
    }
}
