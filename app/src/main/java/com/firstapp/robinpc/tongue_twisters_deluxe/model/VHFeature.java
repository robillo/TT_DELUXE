package com.firstapp.robinpc.tongue_twisters_deluxe.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firstapp.robinpc.tongue_twisters_deluxe.R;

public class VHFeature extends RecyclerView.ViewHolder{

    private ImageView imageView;
    private TextView textView;

    public VHFeature(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.image);
        textView = (TextView) itemView.findViewById(R.id.text);
    }
}
