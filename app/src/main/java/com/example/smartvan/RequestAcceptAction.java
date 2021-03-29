package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RequestAcceptAction extends AppCompatActivity {
    String j,k,l, NIC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_accept_action);

        Intent ii=getIntent();
        Bundle b=ii.getExtras();
        if(b!=null){
            j=(String)b.get("requestId");
            k=(String)b.get("vanId");
            l=(String)b.get("childId");
            NIC = (String)b.get("name");
            //text1.setText(j);
            //text2.setText(k);
            //text3.setText(l);
        }
    }

    public void onAccept(View view) {
        RequestAcceptActionBackend bg=new RequestAcceptActionBackend(this);
        bg.execute(j,l,k, NIC);
        finish();

    }


}