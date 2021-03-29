package com.example.smartvan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleAdapterVan extends RecyclerView.Adapter <RecycleAdapterVan.VanRecyclerViewHolder>{
    private static final int TYPE_HEAD = 0;
    private static final int TYPE_LIST = 1;
    //private RecyclerViewClickListener listener;
    ArrayList<Van> arrayList;
    Context context;
    String r;

    public RecycleAdapterVan(ArrayList<Van> arrayList, Context context,String nic) {
        this.arrayList = arrayList;
        this.context = context;
        this.r=nic;
        //this.listener=listener;
    }

    @NonNull
    @Override
    public VanRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.van_row_layout, parent, false);
        VanRecyclerViewHolder vanrecycleHolder = new VanRecyclerViewHolder(view);
        return vanrecycleHolder;
        //return null;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecycleAdapterVan.VanRecyclerViewHolder holder, final int position) {
        //if(holder.viewType==TYPE_LIST){
        final Van van = arrayList.get(position);
        holder.vanId.setText(van.getVanId());
        holder.seats.setText(Integer.toString(van.getSeats()));
        holder.fillseats.setText(Integer.toString(van.getFillseats()));
        holder.availableseats.setText(Integer.toString(van.getAvailableseats()));
        holder.condition.setText(van.getCondition());
        holder.reg_date.setText(van.getVanreg_date());
        holder.location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6=new Intent(context,ViewVanLocation.class);
                i6.putExtra("vanId",van.getVanId());
                //i6.putExtra("vanId",request.getVanId());
                //i6.putExtra("childId",Integer.toString(request.getChildId()));
                context.startActivity(i6);
            }
        });
        holder.school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6=new Intent(context,ViewVanSchool.class);
                i6.putExtra("vanId",van.getVanId());
                //i6.putExtra("vanId",request.getVanId());
                //i6.putExtra("childId",Integer.toString(request.getChildId()));
                context.startActivity(i6);
            }
        });
        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6=new Intent(context,VanUpdateHome.class);
                i6.putExtra("vanId",van.getVanId());
                i6.putExtra("name",r);
                //i6.putExtra("vanId",request.getVanId());
                //i6.putExtra("childId",Integer.toString(request.getChildId()));
                context.startActivity(i6);

            }
        });
        holder.student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6=new Intent(context,VanStudentHome.class);
                i6.putExtra("vanId",van.getVanId());
                //i6.putExtra("vanId",request.getVanId());
                //i6.putExtra("childId",Integer.toString(request.getChildId()));
                context.startActivity(i6);
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6=new Intent(context,VanRemoveAction.class);
                i6.putExtra("vanId",van.getVanId());
                //i6.putExtra("vanId",request.getVanId());
                //i6.putExtra("childId",Integer.toString(request.getChildId()));
                context.startActivity(i6);
            }
        });
//        holder.reject.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i7=new Intent(context,RequestRejectAction.class);
//                i7.putExtra("requestId",Integer.toString(request.getRequestId()));
//                context.startActivity(i7);
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }





//    @NonNull
//    @Override
//    public RecycleHolder onCreateViewHolder(@NonNull ViewGroup parent) {
////        if(viewType==TYPE_HEAD){
////            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.request_header_layout,parent,false);
////            RecycleHolder recycleHolder=new RecycleHolder(view,viewType);
////            return recycleHolder;
////        }
//        // context=parent.getContext();
////        if (viewType==TYPE_LIST){
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.request_row_layout, parent, false);
//        RecycleHolder recycleHolder = new RecycleHolder(view);
//        return recycleHolder;
//        //}
//        // return null;
//    }








    //meka api hadanna ona
    public class VanRecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView vanId,seats,fillseats,availableseats,condition,reg_date;
        int viewType;
        Button location,school,update,student,delete;

        // private RecycleAdapter.RecyclerViewClickListener listener;
        //private RecycleHolder listener;
        //constructor
        public VanRecyclerViewHolder(View view) {
            super(view);

            //if(viewType==TYPE_LIST){
            vanId=view.findViewById(R.id.vanID2);
            seats=view.findViewById(R.id.vanseats2);
            fillseats=view.findViewById(R.id.vanfillseats2);
            availableseats=view.findViewById(R.id.vanavailable2);
            condition=view.findViewById(R.id.vanconditions2);
            reg_date=view.findViewById(R.id.vanregdate);
            location=view.findViewById(R.id.viewlocation);
            school=view.findViewById(R.id.viewschool);
            update=view.findViewById(R.id.vanupdate);
            student=view.findViewById(R.id.vanstudent);
            delete=view.findViewById(R.id.vandelete);
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
//            else if (viewType==TYPE_HEAD){
//                this.viewType=TYPE_HEAD;
//
//            }


//           view.setOnClickListener(new View.OnClickListener() {
//               @Override
//               public void onClick(View v) {
//                   RecyclerViewClickListener.select()
//               }
//           });
    }
}