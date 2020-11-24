package com.mono.myrecipedb.dao;


import java.nio.file.Files;
import java.nio.file.Paths;


public class JsonDAO {

    public String importJsonFile (String recipePath , String name ) throws Exception {
        //TODO Abfangen Json Datei kann recipe heißen oder den namen des Rezepts haben
        StringBuilder str = new StringBuilder().append(recipePath).append("\\").append("recipe.json");
        System.out.println(str);
        String json = new String(Files.readAllBytes(Paths.get(str.toString())));
        System.out.println(json);

        return json;
    }

    public String findJsonFilePath (String path , String name ){

        return "";

    }


}
