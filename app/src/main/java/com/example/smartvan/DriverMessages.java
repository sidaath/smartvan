package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DriverMessages extends AppCompatActivity {
    String driverID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_messages);

        Intent ii=getIntent();
        Bundle b=ii.getExtras();
        if(b!=null){
            driverID=(String)b.get("driverID");

            // text.setText(j);
        }


    }

    public void messageAllParents(View view){
        Intent intent = new Intent(this, DriverMessageAllParents.class); //implement later
        startActivity(intent);

    }

    public void messageSingleParent(View view){
        Intent intent = new Intent(this, DriverMessageSingleParent.class);
        intent.putExtra("driverID", driverID);
        startActivity(intent);


    }


}