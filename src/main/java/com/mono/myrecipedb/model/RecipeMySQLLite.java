package com.mono.myrecipedb.model;


import javax.persistence.*;


@Entity // Mit Entity Tabellenname im Hybernate default -> klein geschriebener Klassenname
public class RecipeMySQLLite {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO) //Auto increment
    private int id ;
    @Column(nullable = false)
    private String folderPath;

    public RecipeMySQLLite() {
    }

    public RecipeMySQLLite(String folderPath) {
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