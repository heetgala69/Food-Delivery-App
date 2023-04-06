package com.example.fooddeliveryapp;







import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_forgot_password);
    }
    public void reset(View view){
        EditText email = (EditText) findViewById(R.id.email);
        String em = email.getText().toString();
        firebaseAuth.sendPasswordResetEmail(em)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(ForgotPassword.this,"Email Sent",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ForgotPassword.this,MainMenu.class));
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ForgotPassword.this, e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }
}