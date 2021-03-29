package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class DriverRegistration extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    AwesomeValidation awesomeValidation;
    Button createProfile;
    EditText etNIC,etFName,etMName,etLName,etDob,etEmail,etSalary,etContactNumber,etAddress,etLicenceNum,etContract;
    RadioGroup gender;
    String r,selected,g;
    ArrayList<String> listitem=new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_registration);
        Intent i2 = getIntent();
        Bundle b2 = i2.getExtras();
        if (b2 != null) {
            r = (String) b2.get("name");
            // text.setText(r);
        }
        etNIC=findViewById(R.id.driverNic);
        etFName=findViewById(R.id.driverFName);
        etMName=findViewById(R.id.driverMName);
        etLName=findViewById(R.id.driverLName);
        etDob=findViewById(R.id.driverDOB);
        gender=(RadioGroup)findViewById(R.id.driverGender);
        etEmail=findViewById(R.id.driverEmail);
        etSalary=findViewById(R.id.driverSalary);
        etLicenceNum=findViewById(R.id.driverLicence);
        etContactNumber=findViewById(R.id.driverContact);
        etAddress=findViewById(R.id.driverAddress);
        Spinner sp = findViewById(R.id.spinnerVan);
        etContract=findViewById(R.id.driverContract);
        //etPassword=findViewById(R.id.ownerPassword);
        //etCPassword=findViewById(R.id.ownerCPassword);
        //aggrement=findViewById(R.id.agreement);
        createProfile=findViewById(R.id.insertDriver);

        adapter = new ArrayAdapter<>(this, R.layout.spinnerlayout, R.id.vanText, listitem);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(this);

        awesomeValidation=new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.driverNic, RegexTemplate.NOT_EMPTY,R.string.invalid_NIC);
        awesomeValidation.addValidation(this,R.id.driverFName, RegexTemplate.NOT_EMPTY,R.string.invalid_first_name);
        awesomeValidation.addValidation(this,R.id.driverLName, RegexTemplate.NOT_EMPTY,R.string.invalid_last_name);
        awesomeValidation.addValidation(this,R.id.driverDOB, RegexTemplate.NOT_EMPTY,R.string.invalid_Date_of_Birth);
        awesomeValidation.addValidation(this,R.id.driverEmail, Patterns.EMAIL_ADDRESS ,R.string.invalid_email);
        awesomeValidation.addValidation(this,R.id.driverSalary, RegexTemplate.NOT_EMPTY ,R.string.invalid_salary);
        awesomeValidation.addValidation(this,R.id.driverLicence, RegexTemplate.NOT_EMPTY,R.string.invalid_Licence);
        awesomeValidation.addValidation(this,R.id.driverContact,"[0-9]{10}$",R.string.invalid_phone);
        // awesomeValidation.addValidation(this,R.id.ownerGovLicence, RegexTemplate.NOT_EMPTY,R.string.invalid_GLN);
        //awesomeValidation.addValidation(this,R.id.ownerCPassword, R.id.ownerPassword,R.string.invalid_password);
    }
    protected void onStart() {
        super.onStart();
        BackTask bt=new BackTask();
        bt.execute(r);
    }

    public void onDriverRadio(View view) {
        int checkId=gender.getCheckedRadioButtonId();
        switch (checkId){
            case R.id.driverMale:
                g="Male";
                break;
            case R.id.driverFemale:
                g="Female";
                break;
            default:
                g="No";
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        selected=parent.getItemAtPosition(pos).toString();
        //Toast.makeText(getApplicationContext(),selected,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }




    private class BackTask extends AsyncTask<String,Void,Void>{
        ArrayList<String> list;
        String json_string="http://10.0.2.2/smartvan/getVanId.php";
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            list=new ArrayList<>();
        }

        @Override
        protected Void doInBackground(String... params) {
            try {
                String Nic=params[0];
                URL url= new URL(json_string);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
                String post_data= URLEncoder.encode("Nic","UTF-8")+"="+URLEncoder.encode(Nic,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                String result="";
                String line;
                while ((line=bufferedReader.readLine())!=null){
                    result+=line;

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                //  String json_strings=result.toString().trim();
                //JSONObject jsonObject1=new JSONObject(Nic);
                JSONObject jsonObject=new JSONObject(result);
                JSONArray jsonArray=jsonObject.getJSONArray("Server_response");
                int count=0;
                while (count<jsonArray.length()){
                    JSONObject jo=jsonArray.getJSONObject(count);
                    list.add(jo.getString("vanID"));
                    count++;
                    // Request request=new Request(jo.getInt("RequestID"),jo.getString("RequestDate"),jo.getString("Request Van ID"),jo.getInt("Child ID"),jo.getString("Child First Name"),jo.getString("Child Last Name"),jo.getString("Child Location"),jo.getString("Child School"));
                    //publishProgress(request);
                    //Thread.sleep(1000);

                }
                //Log.d("JSON STRING",result);
                //return result.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            listitem.addAll(list);
            adapter.notifyDataSetChanged();
            //super.onPostExecute(aVoid);
        }
    }

    public void onInsertDriver(View view) {
        if(awesomeValidation.validate()){
            String NIC=etNIC.getText().toString();
            String FName=etFName.getText().toString();
            String MName=etMName.getText().toString();
            String LName=etLName.getText().toString();
            String dob=etDob.getText().toString();
            String gender=g;
            String Email=etEmail.getText().toString();
            String salary=etSalary.getText().toString();
            String Address=etAddress.getText().toString();
            String LicenceNum=etLicenceNum.getText().toString();
            String contactNumber=etContactNumber.getText().toString();
            String ownerNIC=r;
            String van=selected;
            String contract=etContract.getText().toString();
            String type="reg";
            DriverRegBackend bg=new DriverRegBackend(this);
            bg.execute(type,NIC,FName,MName,LName,dob,gender,Email,salary,Address,LicenceNum,contactNumber,ownerNIC,van,contract);

        }
    }


}