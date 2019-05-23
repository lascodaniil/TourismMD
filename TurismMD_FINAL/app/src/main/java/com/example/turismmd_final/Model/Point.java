package com.example.turismmd_final.Model;

import com.google.gson.annotations.SerializedName;

public class Point {

    @SerializedName("workHours")
    private String workHours;

    @SerializedName("workDays")
    private String workHDays;

    @SerializedName("type")
    private String type;

    @SerializedName("address")
    private String adress;

    @SerializedName("id")
    private int id;

    @SerializedName("description")
    private String description;

    @SerializedName("price")
    private String price;

    @SerializedName("rating")
    private String rating;

    @SerializedName("locationX")
    private float locationX;

    @SerializedName("locationY")
    private float locationY;

    @SerializedName("name")
    private String name;

    @SerializedName("image")
    private String image;




    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    public String getWorkHDays() {
        return workHDays;
    }

    public void setWorkHDays(String workHDays) {
        this.workHDays = workHDays;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public float getLocationX() {
        return locationX;
    }

    public void setLocationX(float locationX) {
        this.locationX = locationX;
    }

    public float getLocationY() {
        return locationY;
    }

    public void setLocationY(float locationY) {
        this.locationY = locationY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
