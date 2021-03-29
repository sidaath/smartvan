package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RequestRejectAction extends AppCompatActivity {
    String j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_reject_action);
        Intent ii=getIntent();
        Bundle b=ii.getExtras();
        if(b!=null) {
            j = (String) b.get("requestId");
        }
    }

    public void onReject(View view) {
        RequestRejectActionBackend bg=new RequestRejectActionBackend(this);
        bg.execute(j);
        finish();
    }
}