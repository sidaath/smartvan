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

public class RecyclerAdapterChild extends RecyclerView.Adapter <RecyclerAdapterChild.ChildRecyclerViewHolder> {
    private static final int TYPE_HEAD = 0;
    private static final int TYPE_LIST = 1;
    //private RecyclerViewClickListener listener;
    ArrayList<Child> arrayList;
    Context context;
    String van_id;
    public RecyclerAdapterChild(ArrayList<Child> arrayList, Context context, String vanId) {
        this.arrayList = arrayList;
        this.context = context;
        this.van_id=vanId;
        //this.listener=listener;
    }
    public RecyclerAdapterChild.ChildRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_row_layout, parent, false);
        RecyclerAdapterChild.ChildRecyclerViewHolder childrecycleHolder = new RecyclerAdapterChild.ChildRecyclerViewHolder(view);
        return childrecycleHolder;
        //return null;
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterChild.ChildRecyclerViewHolder holder, final int position) {
        //if(holder.viewType==TYPE_LIST){
        final Child child = arrayList.get(position);
        holder.childId.setText(Integer.toString(child.getChildId()));
        holder.fname.setText(child.getChildfname());
        holder.lname.setText(child.getChildlname());
        holder.dob.setText(child.getChilddob());
        holder.school.setText(child.getChildschool());
        holder.gender.setText(child.getChildgender());
        holder.location.setText(child.getChildlocation());
        holder.reg_date.setText(child.getChildregdate());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6=new Intent(context,ChildRemoveAction.class);
                i6.putExtra("childId",Integer.toString(child.getChildId()));
                i6.putExtra("vanID", van_id);
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

    public class ChildRecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView childId,fname,lname,dob,school,gender,location,reg_date;
        int viewType;
        Button delete;

        // private RecycleAdapter.RecyclerViewClickListener listener;
        //private RecycleHolder listener;
        //constructor
        public ChildRecyclerViewHolder(View view) {
            super(view);

            //if(viewType==TYPE_LIST){
            childId = view.findViewById(R.id.childID2);
            fname = view.findViewById(R.id.childFName2);
            lname = view.findViewById(R.id.childLName2);
            dob=view.findViewById(R.id.childdob2);
            school = view.findViewById(R.id.childschool2);
            gender = view.findViewById(R.id.childgender2);
            location= view.findViewById(R.id.childlocation2);
            reg_date=view.findViewById(R.id.childregdate);
            delete=view.findViewById(R.id.deletechild);
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
