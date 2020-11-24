package com.mono.myrecipedb;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MainApplication {

    static Logger log = LogManager.getLogger() ;
    // Rezept Ordner Pfad:
    public static final String recipeDirectoryPath = "D:\\Nextcloud\\Rezepte";

    private static final String GET_ALL= "http://localhost:8080/recipes";
    private static final String GET_ONE= "http://localhost:8080/recipes";

    public static void main(String[] args) {
        log.info("App start");

        SpringApplication.run(MainApplication.class, args);


        RestTemplate restTemplate = new RestTemplate();
        System.out.println("http://localhost:8080/recipes");
        System.out.println(restTemplate.getForObject(GET_ALL, String.class));


    }

}
