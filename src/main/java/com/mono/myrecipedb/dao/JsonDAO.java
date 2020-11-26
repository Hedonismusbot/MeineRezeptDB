package com.mono.myrecipedb.dao;


import com.google.gson.Gson;
import com.mono.myrecipedb.model.json_schema.JsonDataRecipe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;


public class JsonDAO {

    static Logger log = LogManager.getLogger() ;


    public JsonDataRecipe convertJsonStringToJavaObject (String json){
        JsonDataRecipe importedJsonDataRecipe = new JsonDataRecipe();
        //Create a new Gson object
        Gson gson = new Gson();

        //convert the json to  Java object (JsonDataRecipe)
        importedJsonDataRecipe = gson.fromJson(json, JsonDataRecipe.class);

        log.debug(importedJsonDataRecipe.toString());


        return importedJsonDataRecipe;
    }

    /**
     * Importiert Json File und convertiert nach String <p/>
     *( wenn Pfad fehlerhaft wird "{}" zurückgegeben )
     *
     * @param recipePath
     * @param name
     * @return String
     */
    public String importJsonFileToString(String recipePath , String name ) throws Exception {
        Optional<String> jsonPath = findJsonFilePath(recipePath,name );
        String json ;

        if(jsonPath.isPresent()) {
            log.info("Json import to String Rezept: " + name);
            log.debug ("Json import to String Rezept Name: " + name + " Pfad: " + jsonPath.get());
            json = new String(Files.readAllBytes(Paths.get(jsonPath.get())));
            log.trace(json);
        }else{
            log.error("Json Pfad fehlerhaft: " + jsonPath.get()+"\\"+name);
            json = "{}";
        }

        return json;
    }

    /**
     * Holt Pfad der JsonDatei ( Datei kann entweder "recipe" oder den Rezeptnamen haben)
     *
     * @param recipePath
     * @param name
     * @return Optional<String>
     */
    public Optional<String> findJsonFilePath (String recipePath , String name ){
        Optional<String> pathFound ;
        StringBuilder str = new StringBuilder().append(recipePath).append("\\").append("recipe.json");
        File f = new File(str.toString());
        if(f.exists() && f.isFile()) {
            pathFound = Optional.of(str.toString());
            return pathFound;
        }else {
            str = new StringBuilder().append(recipePath).append("\\").append(name).append(".json");
            pathFound = Optional.of(str.toString());
        }
        return pathFound;

    }


}
