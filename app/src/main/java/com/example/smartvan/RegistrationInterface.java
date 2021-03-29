package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegistrationInterface extends AppCompatActivity {
    public CardView parentRegister,vanOwnerRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_interface);
        parentRegister=findViewById(R.id.parentRegister);
        vanOwnerRegister=findViewById(R.id.vanOwnerRegister);
        parentRegister.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent regintent = new Intent(RegistrationInterface.this, ParentRegistration.class);
                startActivity(regintent);
            }
        });

        vanOwnerRegister.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent registerintent = new Intent(RegistrationInterface.this, VanOwnerRegister.class);
                startActivity(registerintent);
            }
        });
    
    }
}