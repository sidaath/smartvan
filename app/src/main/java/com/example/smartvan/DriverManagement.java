package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;

import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DriverManagement extends AppCompatActivity {
    CardView driverReg,driverView,driverRemove;
    String r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_management);
        Intent i2=getIntent();
        Bundle b2=i2.getExtras();
        if(b2!=null){
            r=(String)b2.get("name");
            // text.setText(r);
        }
        driverReg=findViewById(R.id.driverReg);
        driverView=findViewById(R.id.viewDriver);
        driverReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DriverManagement.this,DriverRegistration.class);
                i.putExtra("name",r);
                startActivity(i);
            }
        });

        driverView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(DriverManagement.this,DriverViewDetails.class);
                i1.putExtra("name",r);
                startActivity(i1);
            }
        });


    }
}