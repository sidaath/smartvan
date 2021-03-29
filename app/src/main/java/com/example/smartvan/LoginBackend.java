package com.example.smartvan;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

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

public class LoginBackend extends AsyncTask<String, Void, String> {

    String Nic;
    Context context;
    AlertDialog alertDialog;
    LoginBackend(Context ctx){
        context=ctx;
    }


    @Override
    protected String doInBackground(String... strings) {
        String type=strings[0];
        String login_url="http://10.0.2.2/smartvan/login.php";

        if (type.equals("login")){
            try {
                Nic=strings[1];
                String Password=strings[2];
                URL url= new URL(login_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("Nic","UTF-8")+"="+ URLEncoder.encode(Nic,"UTF-8")+"&"+
                        URLEncoder.encode("Password","UTF-8")+"="+URLEncoder.encode(Password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1));
                String result="";
                String line;
                while ((line=bufferedReader.readLine())!=null){
                    result+=line;

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
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
        alertDialog.setTitle("Login Registration Status");
    }

    @Override
    protected void onPostExecute(String result) {
        String user=Nic;
        if (result!=null && result.equals("van owner")){
            Intent i= new Intent(context,VanOwnerDashboard.class);
            i.putExtra("name",user);
            context.startActivity(i);

//
        }
        else if (result!=null && result.equals("driver")){
            Intent i2= new Intent(context,DriverDashboard.class);
            i2.putExtra("name",user);
            context.startActivity(i2);

        }
        else if (result!=null && result.equals("parent")){
            Intent i3= new Intent(context,ParentDashboard.class);
            i3.putExtra("parent",user);
            context.startActivity(i3);

        }
        else {
            alertDialog.setMessage(result);
            alertDialog.show();
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {

        super.onProgressUpdate(values);
    }
}
