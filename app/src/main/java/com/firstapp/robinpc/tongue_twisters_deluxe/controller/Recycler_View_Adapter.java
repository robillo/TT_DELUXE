package com.firstapp.robinpc.tongue_twisters_deluxe.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firstapp.robinpc.tongue_twisters_deluxe.R;
import com.firstapp.robinpc.tongue_twisters_deluxe.model.Data;
import com.firstapp.robinpc.tongue_twisters_deluxe.model.View_Holder;

import java.util.Collections;
import java.util.List;

/**
 * Created by robinkamboj on 22/01/17.
 */
public class Recycler_View_Adapter extends RecyclerView.Adapter<View_Holder>{

    Context context;
    List<Data> list= Collections.emptyList();
    String Title, subTitle, TT;

    public Recycler_View_Adapter(List<Data> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout, initialize the View_Holder
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new View_Holder(v); //holder is returned (converted to inline)
    }

    @Override
    public void onBindViewHolder(final View_Holder holder, int position) {
        //use the created empty VH created in onCreateVH to populate the current row of the RV
        holder.Title.setText(list.get(position).Title);
        holder.subTitle.setText(list.get(position).subTitle);
        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(isLongClick){

                    /*
                    Title = list.get(position).Title;
                    subTitle = list.get(position).subTitle;
                    TT = list.get(position).TT;
                    holder.intent(Title, subTitle, TT);
                    Toast.makeText(context, "#" + (position+1) + " - " + list.get(position).subTitle + " (Long click)", Toast.LENGTH_SHORT).show();*/
                }
                /*
                else {
                    Title = list.get(position).Title;
                    subTitle = list.get(position).subTitle;
                    TT = list.get(position).TT;
                    holder.intent(Title, subTitle, TT);
                    Toast.makeText(context, "#" + (position+1) + " - " + list.get(position).subTitle, Toast.LENGTH_SHORT).show();
                }*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void insert(int position, Data data){
        list.add(position,data);
        notifyItemInserted(position);
    }

    public void remove(Data data){
        int position= list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }

    public void remove(int position){
        list.remove(position);
        notifyItemRemoved(position);
    }
}
