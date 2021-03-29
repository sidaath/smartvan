package com.example.smartvan;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

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

public class VanSchoolBackend extends AsyncTask<String,Void,String> {

    Context context;
    AlertDialog alertDialog;
    VanSchoolBackend(Context ctx){
        context= ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url="http://10.0.2.2/smartvan/vanSchool.php";
        try {
            String vanId=params[0];
            String school=params[1];

            URL url= new URL(reg_url);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
            String post_data= URLEncoder.encode("vanId","UTF-8")+"="+URLEncoder.encode(vanId,"UTF-8")+"&"+
                    URLEncoder.encode("school","UTF-8")+"="+URLEncoder.encode(school,"UTF-8");


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

        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog=new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Owner Registration Status");
    }

    @Override
    protected void onPostExecute(String result) {
//        if (result!=null && result.equals("successful")){
//            Intent i= new Intent(context,VanSchool.class);
//            i.putExtra("vanname",vanId);
//            context.startActivity(i);
////
//        }
//        else{
        alertDialog.setMessage(result);
        alertDialog.show();
//        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}