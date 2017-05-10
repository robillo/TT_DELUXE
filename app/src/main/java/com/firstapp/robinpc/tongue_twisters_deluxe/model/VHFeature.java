package com.firstapp.robinpc.tongue_twisters_deluxe.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firstapp.robinpc.tongue_twisters_deluxe.R;

public class VHFeature extends RecyclerView.ViewHolder{

    public ImageView photo;
    public TextView header;

    public VHFeature(View itemView) {
        super(itemView);
        photo = (ImageView) itemView.findViewById(R.id.image);
        header = (TextView) itemView.findViewById(R.id.text);
    }
}
