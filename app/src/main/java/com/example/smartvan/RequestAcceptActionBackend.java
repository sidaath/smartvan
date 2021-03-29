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

public class RequestAcceptActionBackend extends AsyncTask<String, Void, String> {
    Context context;
    String NIC;
    AlertDialog alertDialog;
    RequestAcceptActionBackend(Context ctx){
        context= ctx;
    }

    @Override
    protected String doInBackground(String... params) {

        String reg_url="http://10.0.2.2/smartvan/acceptRequest.php";

        try {
            String requestId=params[0];
            String childId=params[1];
            String vanId=params[2];
            NIC = params[3];
            URL url= new URL(reg_url);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
            String post_data= URLEncoder.encode("requestId","UTF-8")+"="+URLEncoder.encode(requestId,"UTF-8")+"&"+
                    URLEncoder.encode("childId","UTF-8")+"="+URLEncoder.encode(childId,"UTF-8")+"&"+
                    URLEncoder.encode("vanId","UTF-8")+"="+URLEncoder.encode(vanId,"UTF-8");

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
//        alertDialog=new AlertDialog.Builder(context).create();
//        alertDialog.setTitle("Status");
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String result) {
        if (result!=null && result.equals("successful")){
            Toast.makeText(context, "Request Accepted", Toast.LENGTH_SHORT).show();
            Intent i= new Intent(context, RequestResponse.class);
            i.putExtra("name", NIC);
            context.startActivity(i);

//
        }
//        else{
//            alertDialog.setMessage(result);
//            alertDialog.show();
//        }
        //super.onPostExecute(s);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
