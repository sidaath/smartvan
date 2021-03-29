package com.example.smartvan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.RecyclerViewHolder> {

    private static final int TYPE_HEAD = 0;
    private static final int TYPE_LIST = 1;
    //private RecyclerViewClickListener listener;
    ArrayList<Request> arrayList;
    Context context;
    String NIC;

    public RecycleAdapter(ArrayList<Request> arrayList, Context context, String nic) {
        this.arrayList = arrayList;
        this.context = context;
        this.NIC=nic;

        //this.listener=listener;
    }



    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.request_row_layout, parent, false);
        RecyclerViewHolder recycleHolder = new RecyclerViewHolder(view);
        return recycleHolder;
        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        //if(holder.viewType==TYPE_LIST){
        final Request request = arrayList.get(position);
        holder.requestId.setText(Integer.toString(request.getRequestId()));
        holder.requestDate.setText(request.getRequestDate());
        holder.vanId.setText(request.getVanId());
        holder.childId.setText(Integer.toString(request.getChildId()));
        holder.fname.setText(request.getFname());
        holder.lname.setText(request.getLname());
        holder.location.setText(request.getLocation());
        holder.school.setText(request.getSchool());
        holder.accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6=new Intent(context,RequestAcceptAction.class);
                i6.putExtra("requestId",Integer.toString(request.getRequestId()));
                i6.putExtra("vanId",request.getVanId());
                i6.putExtra("childId",Integer.toString(request.getChildId()));
                i6.putExtra("name", NIC);
                context.startActivity(i6);
            }
        });
        holder.reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i7=new Intent(context,RequestRejectAction.class);
                i7.putExtra("requestId",Integer.toString(request.getRequestId()));
                context.startActivity(i7);
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    //meka api hadanna ona
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView requestId, requestDate, vanId, childId, fname, lname, location, school;
        int viewType;
        Button accept, reject;

        // private RecycleAdapter.RecyclerViewClickListener listener;
        //private RecycleHolder listener;
        //constructor
        public RecyclerViewHolder(View view) {
            super(view);

            //if(viewType==TYPE_LIST){
            requestId = view.findViewById(R.id.requestID);
            requestDate = view.findViewById(R.id.requestDate);
            vanId = view.findViewById(R.id.VanID);
            childId = view.findViewById(R.id.childId);
            fname = view.findViewById(R.id.childFName);
            lname = view.findViewById(R.id.childLName);
            location = view.findViewById(R.id.childLocation);
            school = view.findViewById(R.id.childSchool);
            accept = view.findViewById(R.id.accept);
            reject = view.findViewById(R.id.reject);
            // this.viewType=viewType;
            //view.setOnClickListener(this);
//                accept.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent i=new Intent(v.getContext(),RequestAcceptAction.class);
//                        i.putExtra("requestId",RecycleAdapter.arrayList.get(getAdapterPosition()));
//                    }
//                });
        }
    }
}


