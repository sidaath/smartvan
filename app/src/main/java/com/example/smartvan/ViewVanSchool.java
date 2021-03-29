package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
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

public class ViewVanSchool extends AppCompatActivity {
    private static final String url_type="http://10.0.2.2/smartvan/viewVanSchool.php";
    ListView etschool;
    ArrayList<String> arrayList=new ArrayList<>();
    String r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_van_school);

        Intent i2=getIntent();
        Bundle b2=i2.getExtras();
        if(b2!=null){
            r=(String)b2.get("vanId");
            // text.setText(r);
        }
        fetchdata(r);
    }
    private void fetchdata(String r) {
        etschool=(ListView)findViewById(R.id.schoollist);
        class dbManager extends AsyncTask<String,Void,String> {

            @Override
            protected String doInBackground(String... params) {
                try {
                    String vanId=params[0];
                    URL url= new URL(url_type);
                    HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
                    String post_data= URLEncoder.encode("vanId","UTF-8")+"="+URLEncoder.encode(vanId,"UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    InputStream inputStream=httpURLConnection.getInputStream();
                    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder result= new StringBuilder();
                    String line;
                    while ((line=bufferedReader.readLine())!=null){
                        result.append(line).append("\n");

                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
//                    String json_strings=result.toString().trim();
//                    //JSONObject jsonObject1=new JSONObject(Nic);
//                    JSONObject jsonObject=new JSONObject(json_strings);
//                    JSONArray jsonArray=jsonObject.getJSONArray("Server_response");
//                    int count=0;
//                    while (count<jsonArray.length()){
//                        JSONObject jo=jsonArray.getJSONObject(count);
//                        count++;
//                        Request request=new Request(jo.getInt("RequestID"),jo.getString("RequestDate"),jo.getString("Request Van ID"),jo.getInt("Child ID"),jo.getString("Child First Name"),jo.getString("Child Last Name"),jo.getString("Child Location"),jo.getString("Child School"));
//                        publishProgress(request);
//                        Thread.sleep(1000);
//
//                    }
//                    Log.d("JSON STRING",json_strings);
                    return result.toString();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String result) {
                try{
                    JSONArray jo=new JSONArray(result);
                    JSONArray jo2 = jo.getJSONArray(0);
                    JSONObject ja=null;
                    int i;
                    arrayList.clear();
                    for(i=0;i<jo2.length();i++){
                        ja=jo2.getJSONObject(i);
                        String vanSchool=ja.getString("school");
                        arrayList.add(vanSchool);
                    }
                    ArrayAdapter<String> at=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,arrayList);
                    etschool.setAdapter(at);

                }catch (Exception ex){
                    ex.printStackTrace();
                }
                //super.onPostExecute(s);
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }
        }
        dbManager obj=new dbManager();
        obj.execute(r);

    }
}