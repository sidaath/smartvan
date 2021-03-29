package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class VanManagement extends AppCompatActivity {
    CardView vanReg,vantask;
    String r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_van_management);
        Intent i2=getIntent();
        Bundle b2=i2.getExtras();
        if(b2!=null){
            r=(String)b2.get("name");
            // text.setText(r);
        }
        vanReg=findViewById(R.id.vanreg);
        vantask=findViewById(R.id.vantask);
        vanReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(VanManagement.this,VanRegistration.class);
                i.putExtra("name",r);
                //Log.d("OWNER_van_reg_click", r);
                startActivity(i);
            }
        });

        vantask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(VanManagement.this,ViewVan.class);
                i1.putExtra("name",r);
                //Log.d("OWNER_van_task_click", r);
                startActivity(i1);
            }
        });
    }
}