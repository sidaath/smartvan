package com.example.smartvan;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

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

public class DriverRegBackend extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    DriverRegBackend(Context ctx){
        context= ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type=params[0];

        String reg_url="http://10.0.2.2/smartvan/driverRegistration.php";
        if (type.equals("reg")){
            try {
                String NIC=params[1];
                String FName=params[2];
                String MName=params[3];
                String LName=params[4];
                String dob=params[5];
                String gender=params[6];
                String Email=params[7];
                String salary=params[8];
                String Address=params[9];
                String LicenceNum=params[10];
                String contactNumber=params[11];
                String ownerNIC= params[12];
                String vanId=params[13];
                String contract=params[14];

                URL url= new URL(reg_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
                String post_data= URLEncoder.encode("NIC","UTF-8")+"="+URLEncoder.encode(NIC,"UTF-8")+"&"+
                        URLEncoder.encode("FName","UTF-8")+"="+URLEncoder.encode(FName,"UTF-8")+"&"+
                        URLEncoder.encode("MName","UTF-8")+"="+URLEncoder.encode(MName,"UTF-8")+"&"+
                        URLEncoder.encode("LName","UTF-8")+"="+URLEncoder.encode(LName,"UTF-8")+"&"+
                        URLEncoder.encode("dob","UTF-8")+"="+URLEncoder.encode(dob,"UTF-8")+"&"+
                        URLEncoder.encode("gender","UTF-8")+"="+URLEncoder.encode(gender,"UTF-8")+"&"+
                        URLEncoder.encode("Email","UTF-8")+"="+URLEncoder.encode(Email,"UTF-8")+"&"+
                        URLEncoder.encode("salary","UTF-8")+"="+URLEncoder.encode(salary,"UTF-8")+"&"+
                        URLEncoder.encode("Address","UTF-8")+"="+URLEncoder.encode(Address,"UTF-8")+"&"+
                        URLEncoder.encode("LicenceNum","UTF-8")+"="+URLEncoder.encode(LicenceNum,"UTF-8")+"&"+
                        URLEncoder.encode("contactNumber","UTF-8")+"="+URLEncoder.encode(contactNumber,"UTF-8")+"&"+
                        URLEncoder.encode("ownerNIC","UTF-8")+"="+URLEncoder.encode(ownerNIC,"UTF-8")+"&"+
                        URLEncoder.encode("vanId","UTF-8")+"="+URLEncoder.encode(vanId,"UTF-8")+"&"+
                        URLEncoder.encode("contract","UTF-8")+"="+URLEncoder.encode(contract,"UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1));
                StringBuilder result= new StringBuilder();
                String line;
                while ((line=bufferedReader.readLine())!=null){
                    result.append(line);
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        //super.onPreExecute();
        alertDialog=new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Owner Registration Status");
    }

    @Override
    protected void onPostExecute(String result) {
        if (result!=null && result.equals("successful")){
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
            Intent i= new Intent(context,DriverManagement.class);
            context.startActivity(i);
//
        }
        else{
            alertDialog.setMessage(result);
            alertDialog.show();
        }
        //super.onPostExecute(s);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}