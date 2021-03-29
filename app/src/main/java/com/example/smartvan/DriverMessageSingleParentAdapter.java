package com.example.smartvan;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DriverMessageSingleParentAdapter extends RecyclerView.Adapter<DriverMessageSingleParentAdapter.ViewHolder> {
    ArrayList<Child> localDataSet;
    Context context;
    public String driverID;


    public DriverMessageSingleParentAdapter(ArrayList<Child> children, String id) {
        localDataSet = children;
        this.driverID=id;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView childName;
        Button message;
        Child thisChild;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            childName = (TextView)itemView.findViewById(R.id.txtDriverMessageSingleChildName);
            message= (Button)itemView.findViewById(R.id.btnDriverMessageSingleChild);

//            message.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(itemView.getContext(), "Clicked Parent", Toast.LENGTH_SHORT).show();
//                    String childId = thisChild.getChildId().toString();
//                    String driverID
//                    Intent intent = new Intent(itemView.getContext(), DriverTypeSingleParentMessage.class);
//                    intent.putExtra("childID",childId);
//                    intent.putExtra("driverID", )
//                    itemView.getContext().startActivity(intent);
//                }
//            });

        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.driver_message_single_parent_row,parent,false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Child child = localDataSet.get(position);
        holder.childName.setText(child.getChildfname());
        holder.thisChild = child;
        String x = driverID;
        holder.message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Clicked Parent", Toast.LENGTH_SHORT).show();
                String childId = child.getChildId().toString();
                String driverID = x;
                Intent intent = new Intent(v.getContext(), DriverTypeSingleParentMessage.class);
                intent.putExtra("childID",childId);
                intent.putExtra("driverID",x );
                v.getContext().startActivity(intent);
                Log.d("DRVR_SEND_MSG_SNGL", x);
            }
        });

    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }


}
