package com.example.smartvan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DriverStartJourney extends AppCompatActivity {
        String driverID;
        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_driver_start_journey);



            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String currentDate = sdf.format(new Date());


            Intent ii=getIntent();
            Bundle b=ii.getExtras();
            if(b!=null){
                driverID=(String)b.get("driverID");

                // text.setText(j);
            }

            DriverMornignTripBackend bg = new DriverMornignTripBackend(this);
            bg.execute(driverID, currentDate);
            //Log.d("Start_J_day", currentDate);


            TextView dateAndTime = (TextView) findViewById(R.id.txtDateAndTime);
            dateAndTime.setText(DateUtils.formatDateTime(this, System.currentTimeMillis(), DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_NUMERIC_DATE));





            //get data from server -> the class you get from server is the DailyTrip
            //in the daily trip class, there is an ArrayList of Children -> pass this array list to the adapter to create recycler view.
            //for now -> creating an array list of children;

            //done adding children to array list
            DriverDailyListBackend getChildren = new DriverDailyListBackend(DriverStartJourney.this);
            getChildren.execute(driverID);


            if (Build.VERSION.SDK_INT >= 23) {
                if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                } else {
                    startLocationUpdates();
                }
            } else {
                startLocationUpdates();
            }

        }

    void startLocationUpdates(){
        Intent intent = new Intent(DriverStartJourney.this, DriverLocationService.class);
        intent.putExtra("driverID", driverID);
        startService(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
                if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    startLocationUpdates();
                }else{
                    Toast.makeText(this, "Permissions Required", Toast.LENGTH_SHORT).show();
                }
        }
    }

        public void viewMap (View view){
            Intent intent = new Intent(this, DriverDailyMap.class);
            startActivity(intent);
        }

        public void endJourney(View view){
            DriverEndJourneyBackend bg = new DriverEndJourneyBackend(this);
            bg.execute(driverID);
            finish();


        }

    }
