package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class VanUpdateHome extends AppCompatActivity {
    String r,j;
    CardView changedriver,changelocation,changeschool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_van_update_home);
        Intent i2=getIntent();
        Bundle b2=i2.getExtras();
        if(b2!=null){
            r=(String)b2.get("vanId");
            j=(String)b2.get("name");
            // text.setText(r);
        }
        changedriver=findViewById(R.id.changedriver);
        changelocation=findViewById(R.id.changelocations);
        changeschool=findViewById(R.id.changeschool);

        changedriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(VanUpdateHome.this,VanDriverChange.class);
                i.putExtra("vanId",r);
                i.putExtra("name",j);
                startActivity(i);
            }
        });
        changelocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(VanUpdateHome.this,VanLocationChange.class);
                i.putExtra("vanId",r);
                startActivity(i);
            }
        });
        changeschool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(VanUpdateHome.this,VanSchoolChange.class);
                i.putExtra("vanId",r);
                startActivity(i);
            }
        });
    }
}