package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogIn extends AppCompatActivity {
    EditText nicEt,passwordEt;
    Button regBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        regBtn=findViewById(R.id.register);
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this, RegistrationInterface.class);
                startActivity(intent);
            }
        });
        nicEt=findViewById(R.id.userId);
        passwordEt=findViewById(R.id.userPassword);
    }

    public void onLogin(View view){
        String Nic=nicEt.getText().toString();
        String Password=passwordEt.getText().toString();
        String type="login";
        LoginBackend bg=new LoginBackend(this);
        bg.execute(type,Nic,Password);
    }
}