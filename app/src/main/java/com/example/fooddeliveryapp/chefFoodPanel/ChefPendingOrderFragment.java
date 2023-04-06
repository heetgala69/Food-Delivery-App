package com.example.fooddeliveryapp.chefFoodPanel;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fooddeliveryapp.MainMenu;
import com.example.fooddeliveryapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import de.hdodenhof.circleimageview.CircleImageView;


public class ChefPendingOrderFragment extends Fragment {

    CircleImageView circleImageView;
    TextView userNameTxt;
    EditText phoneNumberEditTxt, addressEditTxt, cityNameEditTxt, pinCodeEdittxt;
    Button signOutBtn, updateDetailsBtn;
    DatabaseReference databaseReference;
    String userId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chef_pendingorders,null);
        getActivity().setTitle("Profile");

        //Assigning all the addresses of the android materials
        circleImageView = (CircleImageView) v.findViewById(R.id.ProfileImageView);
        userNameTxt = (TextView) v.findViewById(R.id.UserNameTxt);
        cityNameEditTxt = (EditText) v.findViewById(R.id.CityEditText);
        phoneNumberEditTxt = (EditText) v.findViewById(R.id.PhoneNumberEditText);
        pinCodeEdittxt = (EditText) v.findViewById(R.id.PinCodeExitText);
        addressEditTxt = (EditText) v.findViewById(R.id.AddressEditText);


        signOutBtn = (Button) v.findViewById(R.id.SignOutBtn);
        userNameTxt.setText("Heet Gala");
        cityNameEditTxt.setText("Mumbai");
        phoneNumberEditTxt.setText("8767170001");
        pinCodeEdittxt.setText("400063");
        addressEditTxt.setText("Coral Park " + "Goregoan");

        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), MainMenu.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        });


        return v;
    }
}
