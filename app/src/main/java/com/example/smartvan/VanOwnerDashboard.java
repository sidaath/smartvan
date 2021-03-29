package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import android.content.Intent;
import android.os.Bundle;

public class VanOwnerDashboard extends AppCompatActivity {
    public CardView requests,driverManagement,vanManagement,payments,ownerReports;
    private TextView text;
    String j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_van_owner_dashboard);
        requests=findViewById(R.id.requests);
        driverManagement=findViewById(R.id.driverManagement);
        vanManagement=findViewById(R.id.vanManagement);
        payments=findViewById(R.id.payments);
        ownerReports=findViewById(R.id.ownerReports);
        text=(TextView)findViewById(R.id.text);
        Intent ii=getIntent();
        Bundle b=ii.getExtras();
        if(b!=null){
            j=(String)b.get("name");
            // text.setText(j);
        }

        requests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regintent = new Intent(VanOwnerDashboard.this, RequestHome.class);
                regintent.putExtra("name",j);
                startActivity(regintent);
                //text.setText(j);

            }
        });

        driverManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regintent2 = new Intent(VanOwnerDashboard.this, DriverManagement.class);
                regintent2.putExtra("name",j);
                startActivity(regintent2);
            }
        });

        vanManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regintent3 = new Intent(VanOwnerDashboard.this, VanManagement.class);
                regintent3.putExtra("name",j);
                startActivity(regintent3);
            }
        });

        payments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regintent = new Intent(VanOwnerDashboard.this, Payments.class);
                regintent.putExtra("name",j);
                startActivity(regintent);
            }
        });
        ownerReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regintent4 = new Intent(VanOwnerDashboard.this, OwnerReports.class);
                regintent4.putExtra("name",j);
                startActivity(regintent4);
            }
        });


    }

}