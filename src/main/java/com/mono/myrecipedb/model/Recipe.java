package com.mono.myrecipedb.model;


import com.mono.myrecipedb.model.json_schema.JsonDataRecipe;

import javax.persistence.*;
import java.io.Serializable;


@Entity (name = "recipes")//  Tabellenname im Mysql
public class Recipe implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO) //Auto increment
    private int id ;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String folderPath;
    @Column(nullable = false)
    private String json;
    @Transient                                      // dadruch durch JPA ignoriert
    private JsonDataRecipe jsonDataObject = null;

    public Recipe() {
    }

    public Recipe(int id , String name , String folderPath ) {
        this.id = id ;
        this.name = name ;
        this.folderPath = folderPath ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public Recipe(String folderPath) {
        this.folderPath = folderPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }

    public JsonDataRecipe getJsonDataObject() {
        return jsonDataObject;
    }

    public void setJsonDataObject(JsonDataRecipe jsonDataObject) {
        this.jsonDataObject = jsonDataObject;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", folderPath='" + folderPath + '\'' +
                ", json='" + json + '\'' +
                ", jsonDataObject=" + jsonDataObject +
                '}';
    }
}