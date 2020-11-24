package com.mono.myrecipedb.service;

import com.mono.myrecipedb.dao.JsonDAO;
import com.mono.myrecipedb.dao.RecipeSqlLiteDAO;
import com.mono.myrecipedb.model.RecipeSqlLite;
import com.mono.myrecipedb.model.recipe.Recipe;
import com.mono.myrecipedb.util.ListContentOfDirectory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService
{

    @Autowired // Erzeugt/holt Instanz , dependencyinjection (@Inject geht auch )
    private RecipeSqlLiteDAO dao ;

    static Logger log = LogManager.getLogger() ;

    @Override
    public List<RecipeSqlLite> getAllRecipes(String directoryPath) {
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
                dao.save(recipe);
                importetRecipeList.add(recipe);

            } catch (Exception exception) {
                log.error("Rezept SQL NICHT hinzugefügt :\n  Pfad: " +directoryPath +"\n Name: "+ folderFile.getName());

                exception.printStackTrace();
            }
        }
        log.info("Rezepte in SqlLite importiert : " + importetRecipeList.size() );

        return importetRecipeList;
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
