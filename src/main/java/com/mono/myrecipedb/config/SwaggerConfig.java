package com.mono.myrecipedb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration  //Konfiguration -> wird am Anfang ausgeführt
@EnableSwagger2
public class SwaggerConfig {
    // http://localhost:8080/swagger-ui.html#/   -> Api Dokumentation
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())        // Durchsucht Projekt nach Swagger Files
                .paths(PathSelectors.any())                   // Durchsucht Projekt nach Swagger Files
                .build();
    }



}
