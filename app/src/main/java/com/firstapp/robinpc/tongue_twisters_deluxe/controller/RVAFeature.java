package com.firstapp.robinpc.tongue_twisters_deluxe.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.firstapp.robinpc.tongue_twisters_deluxe.R;
import com.firstapp.robinpc.tongue_twisters_deluxe.model.Feature;
import com.firstapp.robinpc.tongue_twisters_deluxe.model.VHFeature;

import java.util.Collections;
import java.util.List;

import jp.wasabeef.glide.transformations.gpu.BrightnessFilterTransformation;

public class RVAFeature extends RecyclerView.Adapter<VHFeature>{

    private Context context;
    private List<Feature> list = Collections.emptyList();

    public RVAFeature(Context context, List<Feature> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public VHFeature onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_features, parent, false);
        return new VHFeature(v);
    }

    @Override
    public void onBindViewHolder(VHFeature holder, int position) {
        holder.header.setText(list.get(position).getHeader() + ": " + list.get(position).getDescription());
        Glide.with(context)
                .load("https://3.bp.blogspot.com/-FTKj7QUV61w/WJBgEaJclgI/AAAAAAAAAFw/dX-wb54JX-AYiDGPPB1Z3lvS7ZCoUNKBACLcB/s1600/ph6.png")
                .bitmapTransform(new BrightnessFilterTransformation(context, -0.4f))
                .into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
