package com.mono.myrecipedb.model.recipe;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mono.myrecipedb.model.RecipeSqlLite;

public class Recipe  implements Serializable {
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
    @SerializedName("keywords")
    @Expose
    private String keywords;
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
    @SerializedName("prepTime")
    @Expose
    private String prepTime;
    @SerializedName("cookTime")
    @Expose
    private String cookTime;
    @SerializedName("totalTime")
    @Expose
    private String totalTime;
    @SerializedName("recipeYield")
    @Expose
    private Integer recipeYield;
    @SerializedName("recipeCategory")
    @Expose
    private String recipeCategory;
    @SerializedName("cookingMethod")
    @Expose
    private String cookingMethod;
    @SerializedName("recipeCuisine")
    @Expose
    private String recipeCuisine;
    @SerializedName("aggregateRating")
    @Expose
    private AggregateRating aggregateRating;
    @SerializedName("nutrition")
    @Expose
    private Nutrition nutrition;
    @SerializedName("review")
    @Expose
    private List<Review> review = null;
    @SerializedName("datePublished")
    @Expose
    private String datePublished;
    @SerializedName("tool")
    @Expose
    private List<Object> tool = null;
    private final static long serialVersionUID = 930431040469941610L;

    // Variablen
    private int sqlLiteId;
    private String folderPath;

    public Recipe(){
    }


    public Recipe(int id , String folderPath){
        setsqlLiteId(id);
        setFolderPath(folderPath);
    }




    public int getsqlLiteId() {
        return sqlLiteId;
    }

    public void setsqlLiteId(int id) {
        this.sqlLiteId = id;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }

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

    public String getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public Recipe withPrepTime(String prepTime) {
        this.prepTime = prepTime;
        return this;
    }

    public String getCookTime() {
        return cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public Recipe withCookTime(String cookTime) {
        this.cookTime = cookTime;
        return this;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public Recipe withTotalTime(String totalTime) {
        this.totalTime = totalTime;
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

    public String getRecipeCategory() {
        return recipeCategory;
    }

    public void setRecipeCategory(String recipeCategory) {
        this.recipeCategory = recipeCategory;
    }

    public Recipe withRecipeCategory(String recipeCategory) {
        this.recipeCategory = recipeCategory;
        return this;
    }

    public String getCookingMethod() {
        return cookingMethod;
    }

    public void setCookingMethod(String cookingMethod) {
        this.cookingMethod = cookingMethod;
    }

    public Recipe withCookingMethod(String cookingMethod) {
        this.cookingMethod = cookingMethod;
        return this;
    }

    public String getRecipeCuisine() {
        return recipeCuisine;
    }

    public void setRecipeCuisine(String recipeCuisine) {
        this.recipeCuisine = recipeCuisine;
    }

    public Recipe withRecipeCuisine(String recipeCuisine) {
        this.recipeCuisine = recipeCuisine;
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

    public Nutrition getNutrition() {
        return nutrition;
    }

    public void setNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
    }

    public Recipe withNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
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

    public List<Object> getTool() {
        return tool;
    }

    public void setTool(List<Object> tool) {
        this.tool = tool;
    }

    public Recipe withTool(List<Object> tool) {
        this.tool = tool;
        return this;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "context='" + context + '\'' +
                ",\n type='" + type + '\'' +
                ",\n name='" + name + '\'' +
                ",\n description='" + description + '\'' +
                ",\n author=" + author +
                ",\n keywords='" + keywords + '\'' +
                ",\n image='" + image + '\'' +
                ",\n url='" + url + '\'' +
                ",\n recipeIngredient=" + recipeIngredient +
                ",\n recipeInstructions=" + recipeInstructions +
                ",\n prepTime='" + prepTime + '\'' +
                ",\n cookTime='" + cookTime + '\'' +
                ",\n totalTime='" + totalTime + '\'' +
                ",\n recipeYield=" + recipeYield +
                ",\n recipeCategory='" + recipeCategory + '\'' +
                ",\n cookingMethod='" + cookingMethod + '\'' +
                ",\n recipeCuisine='" + recipeCuisine + '\'' +
                ",\n aggregateRating=" + aggregateRating +
                ",\n nutrition=" + nutrition +
                ",\n review=" + review +
                ",\n datePublished='" + datePublished + '\'' +
                ",\n tool=" + tool +
                ",\n mySQLLiteId=" + sqlLiteId +
                ",\n folderPath='" + folderPath + '\'' +
                '}';
    }
}
