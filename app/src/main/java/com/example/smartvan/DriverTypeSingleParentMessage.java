package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DriverTypeSingleParentMessage extends AppCompatActivity {
    EditText driverMessage;
    Button sendMessage;
    String j,k; //j is child, k is driver
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_type_single_parent_message);

        Intent ii=getIntent();
        Bundle b=ii.getExtras();
        if(b!=null){
            j=(String)b.get("childID");
            k=(String)b.get("driverID");
        }


        driverMessage = (EditText)findViewById(R.id.etTypeSingleParentMessage);
        sendMessage = (Button)findViewById(R.id.btnDriverSendSingleParentMessage);



        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = driverMessage.getText().toString();
                DriverSendSingleMessageBackend bg = new DriverSendSingleMessageBackend(DriverTypeSingleParentMessage.this);
                bg.execute(message, j, k);
                finish();
            }
        });





    }
}