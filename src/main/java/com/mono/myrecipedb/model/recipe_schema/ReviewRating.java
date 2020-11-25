package com.mono.myrecipedb.model.recipe_schema;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReviewRating implements Serializable
{

    @SerializedName("@type")
    @Expose
    private String type;
    @SerializedName("ratingValue")
    @Expose
    private String ratingValue;
    private final static long serialVersionUID = 8743366428915756180L;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ReviewRating withType(String type) {
        this.type = type;
        return this;
    }

    public String getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(String ratingValue) {
        this.ratingValue = ratingValue;
    }

    public ReviewRating withRatingValue(String ratingValue) {
        this.ratingValue = ratingValue;
        return this;
    }

    @Override
    public String toString() {
        return "ReviewRating{" +
                "type='" + type + '\'' +
                ", ratingValue='" + ratingValue + '\'' +
                '}';
    }
}