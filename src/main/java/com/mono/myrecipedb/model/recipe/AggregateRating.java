package com.mono.myrecipedb.model.recipe;


import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AggregateRating implements Serializable
{

    @SerializedName("@type")
    @Expose
    private String type;
    @SerializedName("reviewCount")
    @Expose
    private String reviewCount;
    @SerializedName("ratingValue")
    @Expose
    private String ratingValue;
    private final static long serialVersionUID = -6226485536213926516L;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AggregateRating withType(String type) {
        this.type = type;
        return this;
    }

    public String getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(String reviewCount) {
        this.reviewCount = reviewCount;
    }

    public AggregateRating withReviewCount(String reviewCount) {
        this.reviewCount = reviewCount;
        return this;
    }

    public String getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(String ratingValue) {
        this.ratingValue = ratingValue;
    }

    public AggregateRating withRatingValue(String ratingValue) {
        this.ratingValue = ratingValue;
        return this;
    }

}