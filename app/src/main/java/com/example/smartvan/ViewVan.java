package com.example.smartvan;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ViewVan extends AppCompatActivity {
    String r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_van);
        Intent i2=getIntent();
        Bundle b2=i2.getExtras();
        if(b2!=null){
            r=(String)b2.get("name");
            // text.setText(r);
        }
        ViewVanBackgroundWorker bg=new ViewVanBackgroundWorker(this, r);
        bg.execute(r);
    }
}