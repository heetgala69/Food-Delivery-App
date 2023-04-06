package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fooddeliveryapp.customerFoodPanel.CustomerHomeFragment;

public class place_order extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_order);

        Button btn= (Button) findViewById(R.id.CompleteOrderBtn) ;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(place_order.this, CustomerHomeFragment.class);
                startActivity(i);
            }
        });
    }
}