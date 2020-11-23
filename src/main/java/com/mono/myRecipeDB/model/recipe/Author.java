package com.mono.myRecipeDB.model.recipe;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Author implements Serializable
{

    @SerializedName("@type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    private final static long serialVersionUID = 5804942480120007615L;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Author withType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author withName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Author withUrl(String url) {
        this.url = url;
        return this;
    }

}