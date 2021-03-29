package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RequestResponse extends AppCompatActivity {
    String NIC;
    Button dashboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_accept);
        Intent i2=getIntent();
        Bundle b2=i2.getExtras();
        if(b2!=null){
            NIC=(String)b2.get("name");
            // text.setText(r);
        }



    }

    @Override
    public void onBackPressed() {
        finish();
    }
}