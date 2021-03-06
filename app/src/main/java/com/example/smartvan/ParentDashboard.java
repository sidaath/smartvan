package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ParentDashboard extends AppCompatActivity {
    String j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_dashboard);

        Intent ii=getIntent();
        Bundle b=ii.getExtras();
        if(b!=null){
            j=(String)b.get("parent");
            // text.setText(j);
        }

        Button myChildren = (Button)findViewById(R.id.btnParentMyChildren);
        myChildren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParentDashboard.this, ParentMyChildren.class);
                intent.putExtra("parentID", j);
                startActivity(intent);
            }
        });
    }


}