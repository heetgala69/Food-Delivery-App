package com.example.fooddeliveryapp.customerFoodPanel;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import com.example.fooddeliveryapp.R;
import com.example.fooddeliveryapp.place_order;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class CustomerCartFragmnet extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_customercart, container, false);
        getActivity().setTitle("Cart");

        // Get a reference to the "Customer" node in Firebase
        DatabaseReference customerRef = FirebaseDatabase.getInstance().getReference("Customer");

// Set up a Firebase query to retrieve the cart items for the current user
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Query userCartQuery = customerRef.child(userId).child("cart");

// Set up the RecyclerView
       // RecyclerView cartItemsRecyclerView = (RecyclerView)v.findViewById(R.id.cart_items_recycler_view);
        //cartItemsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

// Set up the FirebaseRecyclerOptions and FirebaseRecyclerAdapter
        FirebaseRecyclerOptions<CartItem> options =
                new FirebaseRecyclerOptions.Builder<CartItem>()
                        .setQuery(userCartQuery, CartItem.class)
                        .build();
        FirebaseRecyclerAdapter<CartItem, CartItemViewHolder> adapter =
                new FirebaseRecyclerAdapter<CartItem, CartItemViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull CartItemViewHolder holder, int position, @NonNull CartItem model) {
                        // Bind the CartItem object to the ViewHolder
                        holder.bindCartItem(model);
                    }

                    @NonNull
                    @Override
                    public CartItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        // Create a new ViewHolder
                        View itemView = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.cart_item_view, parent, false);
                        return new CartItemViewHolder(itemView);
                    }
                };

// Set the adapter on the RecyclerView
      //  cartItemsRecyclerView.setAdapter(adapter);

// Start listening for changes in the Firebase database and update the RecyclerView accordingly
        adapter.startListening();

      Button btn = (Button)v.findViewById(R.id.order123);

      btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i= new Intent(getContext(),place_order.class);
              startActivity(i);
          }
      });


        return v;
    }

}