package com.example.fooddeliveryapp.chefFoodPanel;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fooddeliveryapp.R;

public class changedeatil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changedeatil);
        Button btn =(Button) findViewById(R.id.CompleteOrderBtn);
        EditText tv = (EditText) findViewById(R.id.UserName) ;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText tv = (EditText) findViewById(R.id.UserName);
                String return1 = String.valueOf(tv.getText());
                Intent i = new Intent(changedeatil.this, ChefHomeFragment.class);
                i.putExtra("price", return1);
                startActivity(i);
            }
        });


    }
}