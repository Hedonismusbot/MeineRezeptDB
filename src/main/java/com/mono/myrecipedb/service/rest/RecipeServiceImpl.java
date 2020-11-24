package com.mono.myrecipedb.service.rest;

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
        List <File> listofFolderPaths =  ListContentOfDirectory.listContent(directoryPath) ;
        JsonDAO jdao = new JsonDAO () ;
        List <RecipeSqlLite> importetRecipeList =  new ArrayList<>();

        for ( File folderPath: listofFolderPaths) {
            try {
                StringBuilder str= new StringBuilder() ;
                RecipeSqlLite recipe = new RecipeSqlLite();
                //
                str = str.append(directoryPath).append("\\").append(folderPath.getName());
                recipe.setFolderPath(str.toString());
                recipe.setName(folderPath.getName());
                recipe.setJson(jdao.importJsonFile(str.toString() , folderPath.getName() ));

                dao.save(recipe);
                importetRecipeList.add(recipe);
              //  log.debug("Rezept SQL hinzugefügt: " +directoryPath+"\\"+ folder);
            } catch (Exception exception) {
              //  log.error("Rezept SQL NICHT hinzugefügt: " +directoryPath+"\\"+ folder);
                exception.printStackTrace();
            }
        }

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
