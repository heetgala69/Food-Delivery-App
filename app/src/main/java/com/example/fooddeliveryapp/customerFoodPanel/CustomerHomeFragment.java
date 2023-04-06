package com.example.fooddeliveryapp.customerFoodPanel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fooddeliveryapp.MainMenu;
import com.example.fooddeliveryapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class CustomerHomeFragment extends Fragment {
    private DatabaseReference mDatabase;

    @Nullable

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_customerhome, null);
        getActivity().setTitle("Home");

        // Get a reference to the Firebase database
        mDatabase = FirebaseDatabase.getInstance().getReference("Customer");

        // Get a reference to the "cart" node in the database
        DatabaseReference cartRef = mDatabase.child("cart");

        // Add an onClickListener to the "Add to Cart" button
        Button addToCartButton = (Button)v.findViewById(R.id.add_to_cart_button);
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the name, price, and quantity of the item
               String itemName = ((TextView)v.findViewById(R.id.item_name)).getText().toString();
                String itemPrice = ((TextView)v.findViewById(R.id.item_price)).getText().toString();
                int itemQuantity = 1;

                // Create a new CartItem object with the item details
                CartItem item = new CartItem(itemName, itemPrice);

                // Get a unique ID for the cart item
                String cartItemId = cartRef.push().getKey();

                // Add the cart item to the "cart" node in the database
                cartRef.child(cartItemId).setValue(item);

                // Show a toast message to confirm that the item was added to the cart
                Toast.makeText(getContext(), "Item added to cart", Toast.LENGTH_SHORT).show();
            }
        });

        Button addToCartButton1 = (Button)v.findViewById(R.id.add_to_cart_button1);
        addToCartButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the name, price, and quantity of the item
                String itemName = ((TextView)v.findViewById(R.id.Butternaan)).getText().toString();
                String itemPrice = ((TextView)v.findViewById(R.id.item_price1)).getText().toString();
                int itemQuantity = 1;

                // Create a new CartItem object with the item details
                CartItem item = new CartItem(itemName, itemPrice);

                // Get a unique ID for the cart item
                String cartItemId = cartRef.push().getKey();

                // Add the cart item to the "cart" node in the database
                cartRef.child(cartItemId).setValue(item);

                // Show a toast message to confirm that the item was added to the cart
                Toast.makeText(getContext(), "Item added to cart", Toast.LENGTH_SHORT).show();
            }
        });

        Button addToCartButton4 = (Button)v.findViewById(R.id.add_to_cart_button4);
        addToCartButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the name, price, and quantity of the item
                String itemName = ((TextView)v.findViewById(R.id.Biryani)).getText().toString();
                String itemPrice = ((TextView)v.findViewById(R.id.item_price4)).getText().toString();
                int itemQuantity = 1;

                // Create a new CartItem object with the item details
                CartItem item = new CartItem(itemName, itemPrice);

                // Get a unique ID for the cart item
                String cartItemId = cartRef.push().getKey();

                // Add the cart item to the "cart" node in the database
                cartRef.child(cartItemId).setValue(item);

                // Show a toast message to confirm that the item was added to the cart
                Toast.makeText(getContext(), "Item added to cart", Toast.LENGTH_SHORT).show();
            }
        });

        Button addToCartButton3 = (Button)v.findViewById(R.id.add_to_cart_button3);
        addToCartButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the name, price, and quantity of the item
                String itemName = ((TextView)v.findViewById(R.id.kadhaipaneer)).getText().toString();
                String itemPrice = ((TextView)v.findViewById(R.id.item_price3)).getText().toString();
                int itemQuantity = 1;

                // Create a new CartItem object with the item details
                CartItem item = new CartItem(itemName, itemPrice);

                // Get a unique ID for the cart item
                String cartItemId = cartRef.push().getKey();

                // Add the cart item to the "cart" node in the database
                cartRef.child(cartItemId).setValue(item);

                // Show a toast message to confirm that the item was added to the cart
                Toast.makeText(getContext(), "Item added to cart", Toast.LENGTH_SHORT).show();
            }
        });



        return v;

    }



    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.logout,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int idd = item.getItemId();
        if(idd == R.id.LOGOUT){
            Logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void Logout() {

        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getActivity(), MainMenu.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}



