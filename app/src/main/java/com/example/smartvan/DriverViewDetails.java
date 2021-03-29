package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class DriverViewDetails extends AppCompatActivity {
    String r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_view_details);
        Intent i2 = getIntent();
        Bundle b2 = i2.getExtras();
        if (b2 != null) {
            r = (String) b2.get("name");
            // text.setText(r);
        }

        DriverViewBackgroundWorker bg=new DriverViewBackgroundWorker(this);
        bg.execute(r);
    }
}