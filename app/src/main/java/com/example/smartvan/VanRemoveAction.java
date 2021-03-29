package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class VanRemoveAction extends AppCompatActivity {
    String j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_van_remove_action);
        Intent ii=getIntent();
        Bundle b=ii.getExtras();
        if(b!=null){
            j=(String)b.get("vanId");

            //text1.setText(j);
            //text2.setText(k);
            //text3.setText(l);
        }
    }
    public void onRemoveVan(View view) {
        VanRemoveActionBackend bg=new VanRemoveActionBackend(this);
        bg.execute(j);

    }
}