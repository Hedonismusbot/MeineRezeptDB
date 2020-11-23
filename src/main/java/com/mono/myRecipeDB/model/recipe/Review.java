package com.mono.myRecipeDB.model.recipe;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Review implements Serializable
{

    @SerializedName("@type")
    @Expose
    private String type;
    @SerializedName("reviewRating")
    @Expose
    private ReviewRating reviewRating;
    @SerializedName("author")
    @Expose
    private Author_ author;
    @SerializedName("datePublished")
    @Expose
    private String datePublished;
    @SerializedName("reviewBody")
    @Expose
    private String reviewBody;
    private final static long serialVersionUID = 5074124096483066122L;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Review withType(String type) {
        this.type = type;
        return this;
    }

    public ReviewRating getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(ReviewRating reviewRating) {
        this.reviewRating = reviewRating;
    }

    public Review withReviewRating(ReviewRating reviewRating) {
        this.reviewRating = reviewRating;
        return this;
    }

    public Author_ getAuthor() {
        return author;
    }

    public void setAuthor(Author_ author) {
        this.author = author;
    }

    public Review withAuthor(Author_ author) {
        this.author = author;
        return this;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public Review withDatePublished(String datePublished) {
        this.datePublished = datePublished;
        return this;
    }

    public String getReviewBody() {
        return reviewBody;
    }

    public void setReviewBody(String reviewBody) {
        this.reviewBody = reviewBody;
    }

    public Review withReviewBody(String reviewBody) {
        this.reviewBody = reviewBody;
        return this;
    }

}