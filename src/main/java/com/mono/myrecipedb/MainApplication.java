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
    public static final String recipeDirectoryPath = "D:\\Nextcloud\\Rezepte";

    private static final String GET_ALL= "http://localhost:8080/recipes";
    private static final String GET_ONE_BY_ID= "http://localhost:8080/recipe/1";
    private static final String GET_ONE_BY_Name= "http://localhost:8080/recipe/recipe-by-Name?name=Spaghetti";

    public static void main(String[] args) {
        log.info("App start");

        SpringApplication.run(MainApplication.class, args);

        RestTemplate restTemplate = new RestTemplate();
        //  Alle in SQL vorhandenen  Rezepte ausgeben
        System.out.println(" ##########      Wird aufgerufen    ---->     http://localhost:8080/recipes  ##########      ");
        System.out.println(restTemplate.getForObject(GET_ALL, String.class));
        //  1 Rezept über SQL ID finden
        System.out.println(" ##########      Wird aufgerufen    ---->     http://localhost:8080/recipe/1 ##########      ");
        System.out.println(restTemplate.getForObject(GET_ONE_BY_ID, String.class));
        //  Rezept Liste über SQL Namen beinhaltet
        System.out.println(" ##########      Wird aufgerufen    ---->     http://localhost:8080/recipe/recipe-by-Name?name=Spaghetti ##########      ");
        System.out.println(restTemplate.getForObject(GET_ONE_BY_Name, String.class));


    }

}
