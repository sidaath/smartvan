package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class DriverMessageSingleParent extends AppCompatActivity {
    String driverID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_message_single_parent);
        Intent ii=getIntent();
        Bundle b=ii.getExtras();
        if(b!=null){
            driverID=(String)b.get("driverID");

            // text.setText(j);
        }

        DriverGetStudentsBackend bg = new DriverGetStudentsBackend(DriverMessageSingleParent.this, driverID);
        bg.execute(driverID);



    }
}