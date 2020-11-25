package com.mono.myrecipedb;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MainApplication {

    static Logger log = LogManager.getLogger() ;

    // ACHTUNG: Rezept Ordner Pfad: (Wird auch von Controller benutzt über statischen Import)
    public static final String RECIPE_DIRECTORY_PATH = "D:\\Nextcloud\\Rezepte";
/*
    private static final String GET_ALL= "http://localhost:8080/recipes";
    private static final String DELETE_ALL= "http://localhost:8080/deleteAll";
    private static final String GET_ONE_BY_ID= "http://localhost:8080/recipe/1";
    private static final String GET_ALL_BY_Name= "http://localhost:8080/recipe/recipe-by-Name?name=Spaghetti";
*/
    public static void main(String[] args) {
        log.info("App start");

        SpringApplication.run(MainApplication.class, args);


    }

}
