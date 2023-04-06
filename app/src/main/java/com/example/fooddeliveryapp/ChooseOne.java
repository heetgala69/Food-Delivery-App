package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseOne extends AppCompatActivity {
    Button Chef,Customer,DeliveryPerson;
    Intent intent;
    String type;
    ConstraintLayout bgimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_one);
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img1),1500);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img2),1500);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img3),1500);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img3),1500);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img5),1500);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img6),1500);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img7),1500);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img8),1500);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img9),1500);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img10),1500);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img11),1500);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img12),1500);
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.img13),1500);

        animationDrawable.setOneShot(false);
        animationDrawable.setEnterFadeDuration(850);
        animationDrawable.setExitFadeDuration(1600);

        bgimage = findViewById(R.id.back3);
        bgimage.setBackgroundDrawable(animationDrawable);
        animationDrawable.start();

        intent = getIntent();
        type = intent.getStringExtra("Home").toString().trim();

        Chef = (Button)findViewById(R.id.chef);
        DeliveryPerson = (Button)findViewById(R.id.delivery);
        Customer = (Button)findViewById(R.id.customer);
    }

    public void chef(View v){
        if(type.equals("Email")){
            Intent loginemail  = new Intent(ChooseOne.this,Cheflogin.class);
            startActivity(loginemail);
            finish();
        }
        if(type.equals("Phone")){
            Intent loginphone  = new Intent(ChooseOne.this,Chefloginphone.class);
            startActivity(loginphone);
            finish();
        }
        if(type.equals("SignUp")){
            Intent Register  = new Intent(ChooseOne.this,ChefRegistration.class);
            startActivity(Register);
        }
    }

    public void Customer(View v){
        if(type.equals("Email")){
            Intent loginemailcust  = new Intent(ChooseOne.this,Login.class);
            startActivity(loginemailcust);
            finish();
        }
        if(type.equals("Phone")){
            Intent loginphonecust  = new Intent(ChooseOne.this,Loginphone.class);
            startActivity(loginphonecust);
            finish();
        }
        if(type.equals("SignUp")){
            Intent Registercust  = new Intent(ChooseOne.this,Registration.class);
            startActivity(Registercust);
        }
    }
    public void Dilevery(View v) {
        if (type.equals("Email")) {
            Intent loginemail = new Intent(ChooseOne.this, Delivery_Login.class);
            startActivity(loginemail);
            finish();
        }
        if (type.equals("Phone")) {
            Intent loginphone = new Intent(ChooseOne.this, Delivery_Loginphone.class);
            startActivity(loginphone);
            finish();
        }
        if (type.equals("SignUp")) {
            Intent Registerdelivery = new Intent(ChooseOne.this, Delivery_Registration.class);
            startActivity(Registerdelivery);
        }

    }
}