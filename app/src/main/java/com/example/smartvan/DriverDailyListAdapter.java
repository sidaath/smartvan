package com.example.smartvan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DriverDailyListAdapter extends RecyclerView.Adapter<DriverDailyListAdapter.ViewHolder> {



    ArrayList<Child> localDataSet;
    Context context;

    public DriverDailyListAdapter(ArrayList<Child> dailyChildren){
        localDataSet = dailyChildren;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        TextView childName;
        Button present, absent;
        Child thisChild;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            childName = (TextView)itemView.findViewById(R.id.txtChildName);
            present = (Button)itemView.findViewById(R.id.btnMarkPresent);
            absent = (Button)itemView.findViewById(R.id.btnMarkAbsent);

            present.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = thisChild.getChildfname();
                    int id = thisChild.getChildId();
                    String childID = Integer.toString(id);
                    DriverMarkPresentBackend bg = new DriverMarkPresentBackend(itemView.getContext());
                    bg.execute(childID, date );
                    Toast.makeText(itemView.getContext(),"You marked "+name+" present", Toast.LENGTH_SHORT).show();
                }
            });

            absent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = thisChild.getChildfname();
                    int id = thisChild.getChildId();
                    String childID = Integer.toString(id);
                    DriverMarkAbsentBackend bg = new DriverMarkAbsentBackend(itemView.getContext());
                    bg.execute(childID, date );
                    Toast.makeText(itemView.getContext(),"You marked "+name+" absent", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.driver_start_journey_row, parent,false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Child child = localDataSet.get(position);

        holder.childName.setText(child.getChildfname());
        holder.thisChild = child;

    }


    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
