package com.mono.myrecipedb;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

    static Logger log = LogManager.getLogger() ;

    // ACHTUNG: Rezept Ordner Pfad: (Wird auch von Controller benutzt über statischen Import)
    public static final String RECIPE_DIRECTORY_PATH = "D:\\Nextcloud\\Rezepte";



    public static void main(String[] args) {
        log.info("App start");

        SpringApplication.run(MainApplication.class, args);


    }

}
