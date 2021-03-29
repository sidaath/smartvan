package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DriverDashboard extends AppCompatActivity {
    String j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_dashboard);

        Intent ii=getIntent();
        Bundle b=ii.getExtras();
        if(b!=null){
            j=(String)b.get("name");
            // text.setText(j);
        }

    }

    public void startJourney(View view){
        Intent intent = new Intent(this, DriverStartJourney.class);
        intent.putExtra("driverID", j);
        startActivity(intent);
    }

    public  void messages(View view){
        Intent intent = new Intent(this, DriverMessages.class);
        intent.putExtra("driverID",j);
        startActivity(intent);
    }

    public  void todaysAttendance(View view){
        Intent intent = new Intent(this, DriverTodaysAttendance.class);
        intent.putExtra("driverID",j);
        startActivity(intent);
    }

    public  void payments(View view){
        Intent intent = new Intent(this, DriverPayments.class);
        startActivity(intent);
    }

    public  void registeredStudents(View view){
        Intent intent = new Intent(this, DriverRegisteredStudents.class);
        startActivity(intent);
    }
}

//public class DriverDashboard extends AppCompatActivity {
//    String j;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_driver_dashboard);
//
//        Intent ii=getIntent();
//        Bundle b=ii.getExtras();
//        if(b!=null){
//            j=(String)b.get("name");
//            // text.setText(j);
//        }
//
//
//
//    }
//}