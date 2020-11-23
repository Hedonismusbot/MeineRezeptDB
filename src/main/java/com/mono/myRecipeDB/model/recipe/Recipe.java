package com.mono.myRecipeDB.model.recipe;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Recipe implements Serializable
{

    @SerializedName("@context")
    @Expose
    private String context;
    @SerializedName("@type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("recipeIngredient")
    @Expose
    private List<String> recipeIngredient = null;
    @SerializedName("recipeInstructions")
    @Expose
    private List<String> recipeInstructions = null;
    @SerializedName("recipeYield")
    @Expose
    private Integer recipeYield;
    @SerializedName("aggregateRating")
    @Expose
    private AggregateRating aggregateRating;
    @SerializedName("video")
    @Expose
    private Video video;
    @SerializedName("review")
    @Expose
    private List<Review> review = null;
    @SerializedName("datePublished")
    @Expose
    private String datePublished;
    @SerializedName("keywords")
    @Expose
    private String keywords;
    private final static long serialVersionUID = -4307267875591997686L;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Recipe withContext(String context) {
        this.context = context;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Recipe withType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Recipe withName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Recipe withDescription(String description) {
        this.description = description;
        return this;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Recipe withAuthor(Author author) {
        this.author = author;
        return this;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Recipe withImage(String image) {
        this.image = image;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Recipe withUrl(String url) {
        this.url = url;
        return this;
    }

    public List<String> getRecipeIngredient() {
        return recipeIngredient;
    }

    public void setRecipeIngredient(List<String> recipeIngredient) {
        this.recipeIngredient = recipeIngredient;
    }

    public Recipe withRecipeIngredient(List<String> recipeIngredient) {
        this.recipeIngredient = recipeIngredient;
        return this;
    }

    public List<String> getRecipeInstructions() {
        return recipeInstructions;
    }

    public void setRecipeInstructions(List<String> recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }

    public Recipe withRecipeInstructions(List<String> recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
        return this;
    }

    public Integer getRecipeYield() {
        return recipeYield;
    }

    public void setRecipeYield(Integer recipeYield) {
        this.recipeYield = recipeYield;
    }

    public Recipe withRecipeYield(Integer recipeYield) {
        this.recipeYield = recipeYield;
        return this;
    }

    public AggregateRating getAggregateRating() {
        return aggregateRating;
    }

    public void setAggregateRating(AggregateRating aggregateRating) {
        this.aggregateRating = aggregateRating;
    }

    public Recipe withAggregateRating(AggregateRating aggregateRating) {
        this.aggregateRating = aggregateRating;
        return this;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Recipe withVideo(Video video) {
        this.video = video;
        return this;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public Recipe withReview(List<Review> review) {
        this.review = review;
        return this;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public Recipe withDatePublished(String datePublished) {
        this.datePublished = datePublished;
        return this;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Recipe withKeywords(String keywords) {
        this.keywords = keywords;
        return this;
    }

}