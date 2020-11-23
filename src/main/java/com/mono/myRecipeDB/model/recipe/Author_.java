package com.mono.myRecipeDB.model.recipe;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Author_ implements Serializable
{

    @SerializedName("@type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    private final static long serialVersionUID = 5948518529762800192L;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Author_ withType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author_ withName(String name) {
        this.name = name;
        return this;
    }

}