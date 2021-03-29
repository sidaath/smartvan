package com.example.smartvan;

import android.content.Context;
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
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ChildRegistrationBackend extends AsyncTask<String, Void, String> {
    Context context;
    public ChildRegistrationBackend(Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... strings) {

        String reg_url="http://10.0.2.2/smartvan/childRegistration.php";

        try {
            String fname = strings[0];
            String mname = strings[1];
            String lname = strings[2];
            String dob = strings[3];
            String school = strings[4];
            String gender = strings[5];
            String location = strings[6];
            String parentID = strings[7];
            Log.d("PARAMS", fname+" "+mname+" "+lname+" "+dob+" "+school+" "+gender+" "+location+" "+parentID);

            URL url= new URL(reg_url);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
            String post_data= URLEncoder.encode("fName","UTF-8")+"="+URLEncoder.encode(fname,"UTF-8")+"&"+
                    URLEncoder.encode("mName","UTF-8")+"="+URLEncoder.encode(mname,"UTF-8")+"&"+
                    URLEncoder.encode("lName","UTF-8")+"="+URLEncoder.encode(lname,"UTF-8")+"&"+
                    URLEncoder.encode("dob","UTF-8")+"="+URLEncoder.encode(dob,"UTF-8")+"&"+
                    URLEncoder.encode("school","UTF-8")+"="+URLEncoder.encode(school,"UTF-8")+"&"+
                    URLEncoder.encode("gender","UTF-8")+"="+URLEncoder.encode(gender,"UTF-8")+"&"+
                    URLEncoder.encode("location","UTF-8")+"="+URLEncoder.encode(location,"UTF-8")+"&"+
                    URLEncoder.encode("parentID", "UTF-8")+"="+URLEncoder.encode(parentID,"UTF-8");
            Log.d("POST_DATA", post_data);
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
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
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
        //super.onPostExecute(s);
        if (s!=null && s.equals("successful")) {
            Toast.makeText(context, "Child Added Successfully", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
        }
    }
}
