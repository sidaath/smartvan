package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DriverTodaysAttendance extends AppCompatActivity {
    String driverID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_todays_attendance);

        Intent ii=getIntent();
        Bundle b=ii.getExtras();
        if(b!=null){
            driverID=(String)b.get("driverID");

            // text.setText(j);
        }

        DriverTodayListBackend bg = new DriverTodayListBackend(this);
        bg.execute(driverID);

    }

    public void startJourney2(View view){
        Intent intent = new Intent(this, DriverStartJourney.class);
        intent.putExtra("driverID", driverID);
        startActivity(intent);
    }
}