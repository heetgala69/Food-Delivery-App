package com.example.fooddeliveryapp.customerFoodPanel;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddeliveryapp.R;

public class CartItemViewHolder extends RecyclerView.ViewHolder {

    private TextView itemNameTextView;
    private TextView itemPriceTextView;
    //private TextView itemQuantityTextView;

    public CartItemViewHolder( View itemView) {
        super(itemView);
        itemNameTextView = itemView.findViewById(R.id.item_name_text_view);
        itemPriceTextView = itemView.findViewById(R.id.item_price_text_view);
        //itemQuantityTextView = itemView.findViewById(R.id.item_quantity_text_view);
    }

    public void bindCartItem(CartItem cartItem) {
        itemNameTextView.setText(cartItem.name);
        itemPriceTextView.setText(cartItem.price);
        //itemQuantityTextView.setText(String.valueOf(cartItem.quantity));
    }
}