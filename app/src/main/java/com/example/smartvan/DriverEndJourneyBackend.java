package com.example.smartvan;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
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
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DriverEndJourneyBackend extends AsyncTask<String,Void,String> {
    Context context;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String currentDate = sdf.format(new Date());
    String driverId;
    public DriverEndJourneyBackend(Context ctx) {
        context=ctx;
    }

    @Override
    protected String doInBackground(String... strings) {
        String reg_url="http://10.0.2.2/smartvan/driverEndJourney.php";

        try{
            driverId=strings[0];
            Log.d("DRI_END_J", currentDate+" "+driverId);
            URL url= new URL(reg_url);
            //Log.d("TRIP_BACK_DAT", currentDate);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
            String post_data= URLEncoder.encode("driverID","UTF-8")+"="+URLEncoder.encode(driverId,"UTF-8")+"&"+
                    URLEncoder.encode("date", "UTF-8")+"="+URLEncoder.encode(currentDate,"UTF-8");
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

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }




        return null;
    }


    @Override
    protected void onPostExecute(String s) {
        if(s!= null && s.equals("successful")){
            Toast.makeText(context, "Morning Trip Ended", Toast.LENGTH_SHORT).show();
        }
    }
}
