package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

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

public class VanDriverChange extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String r,selected,j;
    ArrayList<String> listitem=new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_van_driver_change);
        Intent i2 = getIntent();
        Bundle b2 = i2.getExtras();
        if (b2 != null) {
            r = (String) b2.get("vanId");
            j= (String)b2.get("name");
            // text.setText(r);
        }
        Spinner sp = findViewById(R.id.driver);
        adapter = new ArrayAdapter<>(this, R.layout.spinnerlayout, R.id.vanText, listitem);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(this);
        //sp.setOnItemSelectedListener(this);


    }


    protected void onStart() {
        super.onStart();
        VanDriverChange.BackTask bt=new VanDriverChange.BackTask();
        bt.execute(j);
    }




    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        selected=parent.getItemAtPosition(pos).toString();
        //Toast.makeText(getApplicationContext(),selected,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



    private class BackTask extends AsyncTask<String,Void,Void> {
        ArrayList<String> list;
        String json_string="http://10.0.2.2/smartvan/getDriverID.php";
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            list=new ArrayList<>();
        }

        @Override
        protected Void doInBackground(String... params) {
            try {
               // String vanId=params[0];
                String Nic=params[0];
                Log.d("NIC", Nic);
                URL url= new URL(json_string);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
                String post_data=URLEncoder.encode("Nic","UTF-8")+"="+URLEncoder.encode(Nic,"UTF-8") ;
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
                    list.add(jo.getString("driver_NIC"));
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
    public void onUpdateDriver(View view) {
        String driver =selected;
        String van=r;
        VanDriverChangeBackend bg=new VanDriverChangeBackend(this);
        bg.execute(driver,van);
    }
}