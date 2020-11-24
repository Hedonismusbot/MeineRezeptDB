package com.mono.myrecipedb.model;


import javax.persistence.*;


@Entity // Mit Entity Tabellenname im Hybernate default -> klein geschriebener Klassenname
public class RecipeSqlLite {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO) //Auto increment
    private int id ;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String folderPath;
    @Column(nullable = false)
    private String json;


    public RecipeSqlLite() {
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

    public RecipeSqlLite(String folderPath) {
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


}