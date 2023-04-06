package com.example.fooddeliveryapp.customerFoodPanel;

public class CartItem {

    public String name;
    public String price;


    public CartItem() {
        // Default constructor required for Firebase database
    }

    public CartItem(String name, String price) {
        this.name = name;
        this.price = price;

    }

}