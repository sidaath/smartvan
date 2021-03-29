package com.example.smartvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ParentMyChildren extends AppCompatActivity {
    String j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_my_children);

        Intent ii=getIntent();
        Bundle b=ii.getExtras();
        if(b!=null){
            j=(String)b.get("parentID");
            // text.setText(j);
        }

        Button addChild = (Button)findViewById(R.id.btnParentNewChild);
        addChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParentMyChildren.this, ChildRegistration.class);
                intent.putExtra("parentID", j);
                startActivity(intent);
            }
        });

    }
}