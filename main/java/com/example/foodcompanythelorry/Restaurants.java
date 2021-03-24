package com.example.foodcompanythelorry;

import android.graphics.Bitmap;

public class Restaurants {
    String restaurantName;
    String foodType;
    String rating;
    String address;
    String location;
    int restaurantImage;

    public Restaurants(String restaurantName, String foodType, String rating, String address, String location, int restaurantImage) {
        this.restaurantName = restaurantName;
        this.foodType = foodType;
        this.rating = rating;
        this.address = address;
        this.location = location;
        this.restaurantImage = restaurantImage;
    }

    public String getRating() {
        return rating;
    }

    public String getAddress() {
        return address;
    }

    public String getLocation() {
        return location;
    }

    public String getFoodType() {
        return foodType;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public int getRestaurantImage() {
        return restaurantImage;
    }
}
