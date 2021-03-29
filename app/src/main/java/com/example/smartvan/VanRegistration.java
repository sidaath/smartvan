package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class VanRegistration extends AppCompatActivity {
    AwesomeValidation awesomeValidation;
    EditText etvanId,etSeats,etFillSeats,etAvailSeats,etConditions;
    String r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_van_registration);
        Intent i2=getIntent();
        Bundle b2=i2.getExtras();
        if(b2!=null){
            r=(String)b2.get("name");
            //Log.d("OWNER_vanregistration", r);
            // text.setText(r);
        }
        etvanId=findViewById(R.id.regVanId);
        etSeats=findViewById(R.id.regVanSeats);
        etFillSeats=findViewById(R.id.regVanFillseats);
        etAvailSeats=findViewById(R.id.regVanAvailableSeats);
        etConditions=findViewById(R.id.regConditions);

        awesomeValidation=new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.regVanId, RegexTemplate.NOT_EMPTY,R.string.invalid_van);
        awesomeValidation.addValidation(this,R.id.regVanSeats, RegexTemplate.NOT_EMPTY,R.string.invalid_seats);
        awesomeValidation.addValidation(this,R.id.regVanAvailableSeats, RegexTemplate.NOT_EMPTY,R.string.invalid_seats);
//        awesomeValidation.addValidation(this,R.id.ownerEmail, Patterns.EMAIL_ADDRESS ,R.string.invalid_email);
//        awesomeValidation.addValidation(this,R.id.ownerContact,"[0-9]{10}$",R.string.invalid_phone);
//        awesomeValidation.addValidation(this,R.id.ownerGovLicence, RegexTemplate.NOT_EMPTY,R.string.invalid_GLN);
//        awesomeValidation.addValidation(this,R.id.ownerCPassword, R.id.ownerPassword,R.string.invalid_password);

    }

    public void onCreateNext(View view) {
        if(awesomeValidation.validate()) {
            String vanId = etvanId.getText().toString();
            String seats = etSeats.getText().toString();
            String fillSeats = etFillSeats.getText().toString();
            String availableSeats = etAvailSeats.getText().toString();
            String conditions = etConditions.getText().toString();

            //Log.d("OWNER_@van_registration", r);
            VanRegistrationBackend bg = new VanRegistrationBackend(this);
            bg.execute(vanId, seats, fillSeats, availableSeats, conditions, r);
        }
    }
}