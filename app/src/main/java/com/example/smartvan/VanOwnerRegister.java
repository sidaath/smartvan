package com.example.smartvan;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class VanOwnerRegister extends AppCompatActivity {
    AwesomeValidation awesomeValidation;
    EditText etNIC,etFName,etMName,etLName,etEmail,etContactNumber,etAddress,etGovtLicenceNum,etPassword,etCPassword;
    CheckBox aggrement;
    Button createProfile;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_van_owner_register);

        etNIC=findViewById(R.id.ownerNic);
        etFName=findViewById(R.id.ownerFName);
        etMName=findViewById(R.id.ownerMName);
        etLName=findViewById(R.id.ownerLName);
        etEmail=findViewById(R.id.ownerEmail);
        etContactNumber=findViewById(R.id.ownerContact);
        etAddress=findViewById(R.id.ownerAdLine);
        etGovtLicenceNum=findViewById(R.id.ownerGovLicence);
        etPassword=findViewById(R.id.ownerPassword);
        etCPassword=findViewById(R.id.ownerCPassword);
        aggrement=findViewById(R.id.agreement);
        createProfile=findViewById(R.id.createProfile);

        awesomeValidation=new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.ownerNic, RegexTemplate.NOT_EMPTY,R.string.invalid_NIC);
        awesomeValidation.addValidation(this,R.id.ownerFName, RegexTemplate.NOT_EMPTY,R.string.invalid_first_name);
        awesomeValidation.addValidation(this,R.id.ownerLName, RegexTemplate.NOT_EMPTY,R.string.invalid_last_name);
        awesomeValidation.addValidation(this,R.id.ownerEmail, Patterns.EMAIL_ADDRESS ,R.string.invalid_email);
        awesomeValidation.addValidation(this,R.id.ownerContact,"[0-9]{10}$",R.string.invalid_phone);
        awesomeValidation.addValidation(this,R.id.ownerGovLicence, RegexTemplate.NOT_EMPTY,R.string.invalid_GLN);
        awesomeValidation.addValidation(this,R.id.ownerCPassword, R.id.ownerPassword,R.string.invalid_password);
    }

    public void onReg(View view) {
        if(awesomeValidation.validate() && aggrement.isChecked()){
            String NIC=etNIC.getText().toString();
            String FName=etFName.getText().toString();
            String MName=etMName.getText().toString();
            String LName=etLName.getText().toString();
            String Email=etEmail.getText().toString();
            String Address=etAddress.getText().toString();
            String contactNumber=etContactNumber.getText().toString();
            String GovtLicenceNum=etGovtLicenceNum.getText().toString();
            String Password=etPassword.getText().toString();
            String type="reg";
            VanOwnerRegBackend bg=new VanOwnerRegBackend(this);
            bg.execute(type,NIC,FName,MName,LName,Email,GovtLicenceNum,Address,contactNumber,Password);

        }
    }
}