package com.example.fooddeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void signinemail(View v){
        Intent signinemail=new Intent(MainMenu.this,ChooseOne.class);
        signinemail.putExtra("Home","Email");
        startActivity(signinemail);
        finish();
    }

    public void signinphone(View v){
        Intent signinphone=new Intent(MainMenu.this,ChooseOne.class);
        signinphone.putExtra("Home","Phone");
        startActivity(signinphone);
        finish();
    }


    public void signinup(View v){
        Intent signinup=new Intent(MainMenu.this,ChooseOne.class);
        signinup.putExtra("Home","SignUp");
        startActivity(signinup);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
    }


}