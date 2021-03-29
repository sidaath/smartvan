package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;

import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class VanStudentHome extends AppCompatActivity {
    String r;
    CardView retrieve,remove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_van_student_home);
        Intent i2=getIntent();
        Bundle b2=i2.getExtras();
        if(b2!=null){
            r=(String)b2.get("vanId");
            //j=(String)b2.get("name");
            // text.setText(r);
        }
//        retrieve=findViewById(R.id.retrieve);
//        remove=findViewById(R.id.remove);
//        retrieve.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(VanStudentHome.this,VanStudentShow.class);
//                i.putExtra("vanId",r);
//                startActivity(i);
//            }
//        });
//
//        remove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(VanStudentHome.this,VanStudentRemove.class);
//                i.putExtra("vanId",r);
//                startActivity(i);
//            }
//        });

        ViewStudentBackgroundWorker bg=new ViewStudentBackgroundWorker(this,r);
        Log.d("VanStHm vanid", r);
        bg.execute(r);
    }
}