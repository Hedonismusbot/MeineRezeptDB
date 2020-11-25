package com.mono.myrecipedb.model.recipe_schema;


import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nutrition implements Serializable
{

    @SerializedName("servingSize")
    @Expose
    private String servingSize;
    @SerializedName("calories")
    @Expose
    private String calories;
    @SerializedName("sugarContent")
    @Expose
    private String sugarContent;
    @SerializedName("sodiumContent")
    @Expose
    private String sodiumContent;
    @SerializedName("fatContent")
    @Expose
    private String fatContent;
    @SerializedName("saturatedFatContent")
    @Expose
    private String saturatedFatContent;
    @SerializedName("unsaturatedFatContent")
    @Expose
    private String unsaturatedFatContent;
    @SerializedName("transFatContent")
    @Expose
    private String transFatContent;
    @SerializedName("carbohydrateContent")
    @Expose
    private String carbohydrateContent;
    @SerializedName("fiberContent")
    @Expose
    private String fiberContent;
    @SerializedName("proteinContent")
    @Expose
    private String proteinContent;
    @SerializedName("cholesterolContent")
    @Expose
    private String cholesterolContent;
    @SerializedName("@type")
    @Expose
    private String type;
    private final static long serialVersionUID = -3543743190438751983L;

    public String getServingSize() {
        return servingSize;
    }

    public void setServingSize(String servingSize) {
        this.servingSize = servingSize;
    }

    public Nutrition withServingSize(String servingSize) {
        this.servingSize = servingSize;
        return this;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public Nutrition withCalories(String calories) {
        this.calories = calories;
        return this;
    }

    public String getSugarContent() {
        return sugarContent;
    }

    public void setSugarContent(String sugarContent) {
        this.sugarContent = sugarContent;
    }

    public Nutrition withSugarContent(String sugarContent) {
        this.sugarContent = sugarContent;
        return this;
    }

    public String getSodiumContent() {
        return sodiumContent;
    }

    public void setSodiumContent(String sodiumContent) {
        this.sodiumContent = sodiumContent;
    }

    public Nutrition withSodiumContent(String sodiumContent) {
        this.sodiumContent = sodiumContent;
        return this;
    }

    public String getFatContent() {
        return fatContent;
    }

    public void setFatContent(String fatContent) {
        this.fatContent = fatContent;
    }

    public Nutrition withFatContent(String fatContent) {
        this.fatContent = fatContent;
        return this;
    }

    public String getSaturatedFatContent() {
        return saturatedFatContent;
    }

    public void setSaturatedFatContent(String saturatedFatContent) {
        this.saturatedFatContent = saturatedFatContent;
    }

    public Nutrition withSaturatedFatContent(String saturatedFatContent) {
        this.saturatedFatContent = saturatedFatContent;
        return this;
    }

    public String getUnsaturatedFatContent() {
        return unsaturatedFatContent;
    }

    public void setUnsaturatedFatContent(String unsaturatedFatContent) {
        this.unsaturatedFatContent = unsaturatedFatContent;
    }

    public Nutrition withUnsaturatedFatContent(String unsaturatedFatContent) {
        this.unsaturatedFatContent = unsaturatedFatContent;
        return this;
    }

    public String getTransFatContent() {
        return transFatContent;
    }

    public void setTransFatContent(String transFatContent) {
        this.transFatContent = transFatContent;
    }

    public Nutrition withTransFatContent(String transFatContent) {
        this.transFatContent = transFatContent;
        return this;
    }

    public String getCarbohydrateContent() {
        return carbohydrateContent;
    }

    public void setCarbohydrateContent(String carbohydrateContent) {
        this.carbohydrateContent = carbohydrateContent;
    }

    public Nutrition withCarbohydrateContent(String carbohydrateContent) {
        this.carbohydrateContent = carbohydrateContent;
        return this;
    }

    public String getFiberContent() {
        return fiberContent;
    }

    public void setFiberContent(String fiberContent) {
        this.fiberContent = fiberContent;
    }

    public Nutrition withFiberContent(String fiberContent) {
        this.fiberContent = fiberContent;
        return this;
    }

    public String getProteinContent() {
        return proteinContent;
    }

    public void setProteinContent(String proteinContent) {
        this.proteinContent = proteinContent;
    }

    public Nutrition withProteinContent(String proteinContent) {
        this.proteinContent = proteinContent;
        return this;
    }

    public String getCholesterolContent() {
        return cholesterolContent;
    }

    public void setCholesterolContent(String cholesterolContent) {
        this.cholesterolContent = cholesterolContent;
    }

    public Nutrition withCholesterolContent(String cholesterolContent) {
        this.cholesterolContent = cholesterolContent;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Nutrition withType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "Nutrition{" +
                "servingSize='" + servingSize + '\'' +
                ", calories='" + calories + '\'' +
                ", sugarContent='" + sugarContent + '\'' +
                ", sodiumContent='" + sodiumContent + '\'' +
                ", fatContent='" + fatContent + '\'' +
                ", saturatedFatContent='" + saturatedFatContent + '\'' +
                ", unsaturatedFatContent='" + unsaturatedFatContent + '\'' +
                ", transFatContent='" + transFatContent + '\'' +
                ", carbohydrateContent='" + carbohydrateContent + '\'' +
                ", fiberContent='" + fiberContent + '\'' +
                ", proteinContent='" + proteinContent + '\'' +
                ", cholesterolContent='" + cholesterolContent + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}