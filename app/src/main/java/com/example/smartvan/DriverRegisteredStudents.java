package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class DriverRegisteredStudents extends AppCompatActivity {
    String driverID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_registered_students);

        Intent ii=getIntent();
        Bundle b=ii.getExtras();
        if(b!=null){
            driverID=(String)b.get("driverID");

            // text.setText(j);
        }

        GetDriverRegisteredStudents bg = new GetDriverRegisteredStudents(this);
        bg.execute(driverID);



    }
}