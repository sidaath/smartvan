package com.example.smartvan;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class DriverDailyListBackend extends AsyncTask<String, Child, Void> {

    Context context;
    Activity activity;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    DriverDailyListAdapter dailyListAdapter;

    public static ArrayList<Child> childrenArrayList = new ArrayList<>();

    String link = "http://10.0.2.2/smartvan/getDailyList.php";

    public DriverDailyListBackend(Context context) {
        this.context = context;
        activity = (Activity)context;
    }

    @Override
    protected void onPreExecute() {
        recyclerView = (RecyclerView)activity.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        dailyListAdapter = new DriverDailyListAdapter(childrenArrayList);
        recyclerView.setAdapter(dailyListAdapter);

    }

    @Override
    protected Void doInBackground(String... params) {

        try{
            String driverID = params[0];
            URL url = new URL(link);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
            String post_data= URLEncoder.encode("driverId","UTF-8")+"="+URLEncoder.encode(driverID,"UTF-8");
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();


            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while((line=bufferedReader.readLine())!=null){
                stringBuilder.append(line+"\n");
            }
            httpURLConnection.disconnect();
            String json_string =  stringBuilder.toString().trim();
            JSONObject jsonObject = new JSONObject(json_string);
            JSONArray jsonArray = jsonObject.getJSONArray("Server_response");
            Log.d("JSON_RE", jsonArray.toString());
            int count =0;
            while(count<jsonArray.length()){
                JSONObject jo =jsonArray.getJSONObject(count);
                count++;
                Child child = new Child(jo.getInt("childId"),jo.getString("fname"),jo.getString("lname"),jo.getString("dob"),jo.getString("school"),jo.getString("gender"),jo.getString("location"),jo.getString("reg_date"));
                publishProgress(child);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onProgressUpdate(Child... values) {
        childrenArrayList.add(values[0]);
        dailyListAdapter.notifyDataSetChanged();

    }



}
