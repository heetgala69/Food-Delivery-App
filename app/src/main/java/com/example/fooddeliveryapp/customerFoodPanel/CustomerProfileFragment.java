package com.example.fooddeliveryapp.customerFoodPanel;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fooddeliveryapp.MainMenu;
import com.example.fooddeliveryapp.R;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;


public class CustomerProfileFragment extends Fragment {
    CircleImageView circleImageView;
    TextView userNameTxt;
    EditText phoneNumberEditTxt, addressEditTxt, cityNameEditTxt, pinCodeEdittxt;
    Button signOutBtn, updateDetailsBtn;
    DatabaseReference databaseReference;
    String userId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customerprofile, null);
        getActivity().setTitle("Profile");


        //Assigning all the addresses of the android materials
        circleImageView = (CircleImageView) view.findViewById(R.id.ProfileImageView);
        userNameTxt = (TextView) view.findViewById(R.id.UserNameTxt);
        cityNameEditTxt = (EditText) view.findViewById(R.id.CityEditText);
        phoneNumberEditTxt = (EditText) view.findViewById(R.id.PhoneNumberEditText);
        pinCodeEdittxt = (EditText) view.findViewById(R.id.PinCodeExitText);
        addressEditTxt = (EditText) view.findViewById(R.id.AddressEditText);


        signOutBtn = (Button) view.findViewById(R.id.SignOutBtn);
        userNameTxt.setText("Aditya Chaturvedi");
        cityNameEditTxt.setText("Mumbai");
        phoneNumberEditTxt.setText("8169275019");
        pinCodeEdittxt.setText("400101");
        addressEditTxt.setText("Thakur Village " + " Khandivali");

        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), MainMenu.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        });
        return view;
    }
}