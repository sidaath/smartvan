package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ChildRegistration extends AppCompatActivity {
    Spinner schoolSpinner, locationSpinner;
    EditText firstName, middleName, lastName, dateOfBirth;
    RadioGroup gender;
    String j,g, childSchool, childLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_registration);

        Intent ii=getIntent();
        Bundle b=ii.getExtras();
        if(b!=null){
            j=(String)b.get("parentID");
            // text.setText(j);
        }
        firstName = (EditText)findViewById(R.id.childFNamex);
        middleName= (EditText)findViewById(R.id.childMNameX);
        lastName= (EditText)(EditText)findViewById(R.id.childLNameX);
        dateOfBirth= (EditText)findViewById(R.id.childDOBX);
        schoolSpinner = (Spinner)findViewById(R.id.childSchoolSpinner);
        ArrayList<String> schoolList = new ArrayList<>() ;
        schoolList.add("WESTERN PROVINCE::");schoolList.add("Ananda College, Colombo");
        schoolList.add("Ananda Balika Vidyalaya, Colombo");
        schoolList.add("Anula Vidyalaya, Nugegoda");
        schoolList.add("Buddhist Ladies' College");
        schoolList.add("Asoka College, Colombo 10.");
        schoolList.add("C. W. W. Kannangara College");
        schoolList.add("Carey College Colombo");
        schoolList.add("D. S. Senanayake College, Colombo");
        schoolList.add("Devi Balika Vidyalaya, Colombo");
        schoolList.add("Gothami Balika Vidyalaya, Colombo");
        schoolList.add("Kolonnawa Balika Vidyalaya, Colombo");
        schoolList.add("Mahanama College, Colombo");
        schoolList.add("Nalanda College, Colombo");
        schoolList.add("Royal College, Colombo");
        schoolList.add("Thurstan College, Colombo");
        schoolList.add("Visakha Vidyalaya, Colombo");
        schoolList.add("Zahira College, Colombo");
        schoolSpinner.setAdapter(new ArrayAdapter<>(ChildRegistration.this,android.R.layout.simple_spinner_dropdown_item,schoolList));
        schoolSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){

                }else{
                    childSchool=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),"Please Select School", Toast.LENGTH_LONG).show();
            }
        });
        gender=(RadioGroup)findViewById(R.id.childGender);

        locationSpinner=(Spinner)findViewById(R.id.childlocationSpinner);
        ArrayList<String> locationList= new ArrayList<>();
        locationSpinner.setAdapter(new ArrayAdapter<>(ChildRegistration.this,android.R.layout.simple_spinner_dropdown_item,locationList));
        locationList.add("WESTERN PROVINCE::");locationList.add("Gampha");locationList.add("Agalawatta");locationList.add("Akarawita");locationList.add("Beruwala");locationList.add("Bokalagama");locationList.add("Dodangoda");locationList.add("Dunagaha");locationList.add("Danawala Thiniyawala");
        locationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){

                }else{
                    childLocation=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ChildRegistration.this, "Please Select Location", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onChildRadio(View view) {
        int checkId=gender.getCheckedRadioButtonId();
        switch (checkId){
            case R.id.childMale:
                g="Male";
                break;
            case R.id.childFemale:
                g="Female";
                break;
            default:
                g="No";
        }
    }

    public void registerChild(View view){
        String fname = firstName.getText().toString();
        String mname = middleName.getText().toString();
        String lname = lastName.getText().toString();
        String dob= dateOfBirth.getText().toString();
        String school = childSchool;
        String gender = g;
        String location = childLocation;

        Log.d("PARAMS_ChldReg", fname+" "+mname+" "+lname+" "+dob+" "+school+" "+gender+" "+location+" "+j);

        ChildRegistrationBackend bg = new ChildRegistrationBackend(ChildRegistration.this);
        bg.execute(fname,mname,lname,dob,school,gender,location,j);

    }



}