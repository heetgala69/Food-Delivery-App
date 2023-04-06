package com.example.fooddeliveryapp.chefFoodPanel;

public class Dish {
    public String name,description,quantity,price,imgID;

    public Dish(String name,String description, String quantity, String price, String imgID){
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.imgID = imgID;
    }
}
