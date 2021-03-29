package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
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

public class ParentRegBackend extends AsyncTask<String, Void, String> {

    Context context;
    AlertDialog alertDialog;
    ParentRegBackend(Context ctx){
        context= ctx;
    }

    @Override
    protected String doInBackground(String... strings) {

        String type=strings[0];

        String reg_url="http://10.0.2.2/smartvan/parentRegistration.php";
        if (type.equals("reg")){
            try {
                String NIC=strings[1];
                String FName=strings[2];
                String MName=strings[3];
                String LName=strings[4];
                String Email=strings[5];
                String contactNumber=strings[6];
                String Address=strings[7];
                String Area=strings[8];
                String Password=strings[9];
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
                        URLEncoder.encode("Email","UTF-8")+"="+URLEncoder.encode(Email,"UTF-8")+"&"+
                        URLEncoder.encode("contactNumber","UTF-8")+"="+URLEncoder.encode(contactNumber,"UTF-8")+"&"+
                        URLEncoder.encode("Address","UTF-8")+"="+URLEncoder.encode(Address,"UTF-8")+"&"+
                        URLEncoder.encode("Location","UTF-8")+"="+URLEncoder.encode(Area,"UTF-8")+"&"+
                        URLEncoder.encode("Password","UTF-8")+"="+URLEncoder.encode(Password,"UTF-8");

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
        alertDialog=new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Owner Registration Status");
    }

    @Override
    protected void onPostExecute(String result) {
        if (result!=null && result.equals("successful")){
            Toast.makeText(context, "Registration Successful. Please Log In.", Toast.LENGTH_LONG).show();
            Intent i= new Intent(context,LogIn.class);
            context.startActivity(i);

        }
        else{
            alertDialog.setMessage(result);
            alertDialog.show();
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
