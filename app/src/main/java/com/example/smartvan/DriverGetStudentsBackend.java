package com.example.smartvan;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class DriverGetStudentsBackend extends AsyncTask<String,Child,Void> {
    Context context;
    String driverID;
    Activity activity;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    DriverMessageSingleParentAdapter driverMessageSingleParentAdapter;
    public  static ArrayList<Child> regChildren = new ArrayList<>();
    String link = "http://10.0.2.2/smartvan/driverGetStudents.php";

    public DriverGetStudentsBackend(Context ctx, String id) {
        this.context = ctx;
        this.driverID=id;
        activity = (Activity)context;
    }

    @Override
    protected Void doInBackground(String... strings) {

        try {
            String driverID = strings[0];
            Log.d("DRVR_GTBKEND", driverID);
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

            int count =0;
            while(count<jsonArray.length()){
                JSONObject jo =jsonArray.getJSONObject(count);
                count++;
                Child child = new Child(jo.getInt("childId"),jo.getString("fname"),jo.getString("lname"),jo.getString("dob"),jo.getString("school"),jo.getString("gender"),jo.getString("location"),jo.getString("reg_date"));
                publishProgress(child);
            }
            Log.d("JSON_RE", jsonArray.toString());


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPreExecute() {
        recyclerView = (RecyclerView)activity.findViewById(R.id.recyclerViewMessageSingleParent);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        driverMessageSingleParentAdapter = new DriverMessageSingleParentAdapter(regChildren, driverID);
        recyclerView.setAdapter(driverMessageSingleParentAdapter);
    }

    @Override
    protected void onProgressUpdate(Child... values) {
        regChildren.add(values[0]);
        driverMessageSingleParentAdapter.notifyDataSetChanged();
    }
}
