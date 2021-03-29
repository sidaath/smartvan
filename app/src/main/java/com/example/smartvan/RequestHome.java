package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


import android.os.Bundle;

public class RequestHome extends AppCompatActivity {

    private TextView text;
    String r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_home);
        text=(TextView)findViewById(R.id.text);
        Intent i2=getIntent();
        Bundle b2=i2.getExtras();
        if(b2!=null){
            r=(String)b2.get("name");
            // text.setText(r);
        }
        // assert r != null;
        // String user= r;
        RequestBackgroundWorker bg=new RequestBackgroundWorker(this);
        bg.execute(r);


    }
}