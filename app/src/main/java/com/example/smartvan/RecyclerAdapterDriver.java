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

public class RecyclerAdapterDriver extends RecyclerView.Adapter <RecyclerAdapterDriver.DriverRecyclerViewHolder> {
    private static final int TYPE_HEAD = 0;
    private static final int TYPE_LIST = 1;
    //private RecyclerViewClickListener listener;
    ArrayList<Driver> arrayList;
    Context context;

    public RecyclerAdapterDriver(ArrayList<Driver> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        //this.listener=listener;
    }

    @NonNull
    @Override
    public DriverRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.driver_row_layout, parent, false);
        DriverRecyclerViewHolder driverrecycleHolder = new DriverRecyclerViewHolder(view);
        return driverrecycleHolder;
        //return null;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterDriver.DriverRecyclerViewHolder holder, final int position) {
        //if(holder.viewType==TYPE_LIST){
        final Driver driver = arrayList.get(position);
        holder.driverId.setText(driver.getDriverId());
        holder.fname.setText(driver.getDriverfname());
        holder.lname.setText(driver.getDriverlname());
        holder.dob.setText(driver.getDriverdob());
        holder.gender.setText(driver.getDrivergender());
        holder.email.setText(driver.getDriveremail());
        holder.salary.setText(driver.getDriversalary());
        holder.address.setText(driver.getDriveraddress());
        holder.license.setText(driver.getDriverlicence());
        holder.phone.setText(Integer.toString(driver.getDrivercontact()));
        holder.van.setText(driver.getDrivervan());
        holder.contract.setText(driver.getDrivercontract());
        holder.reg_date.setText(driver.getDriverReg_date());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6=new Intent(context,DriverRemoveAction.class);
                i6.putExtra("driverId",driver.getDriverId());
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
    public class DriverRecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView driverId,fname,lname,dob,gender,email,salary,address,license,phone,van,contract,reg_date;
        int viewType;
        Button delete;

        // private RecycleAdapter.RecyclerViewClickListener listener;
        //private RecycleHolder listener;
        //constructor
        public DriverRecyclerViewHolder(View view) {
            super(view);

            //if(viewType==TYPE_LIST){
            driverId = view.findViewById(R.id.driverID2);
            fname = view.findViewById(R.id.driverFName2);
            lname = view.findViewById(R.id.driverLName2);
            dob=view.findViewById(R.id.driverdob2);
            gender = view.findViewById(R.id.drivergender2);
            email= view.findViewById(R.id.driveremail2);
            salary = view.findViewById(R.id.driversalary2);
            address = view.findViewById(R.id.driveraddress2);
            license= view.findViewById(R.id.driverlicence2);
            phone= view.findViewById(R.id.drivercontact2);
            van= view.findViewById(R.id.drivervan2);
            contract= view.findViewById(R.id.drivercontract2);
            reg_date=view.findViewById(R.id.driverregdate);
            delete=view.findViewById(R.id.deletedriver);
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
