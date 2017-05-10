package com.firstapp.robinpc.tongue_twisters_deluxe.view.slides;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.firstapp.robinpc.tongue_twisters_deluxe.R;
import com.firstapp.robinpc.tongue_twisters_deluxe.view.activities.DetailActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Slide4Fragment extends Fragment {

    public Slide4Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_slide4, container, false);

        CardView cardView = (CardView) v.findViewById(R.id.cardView);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
        TextView level = (TextView) v.findViewById(R.id.level);
        level.setText(getResources().getString(R.string.slide_4_title));
        TextView level_header = (TextView) v.findViewById(R.id.level_header);
        level_header.setText(getResources().getString(R.string.slide_4_desc));

        Glide.with(this)
                .load("http://2.bp.blogspot.com/-k1SRZ0vh8MI/WRH6PNTiE1I/AAAAAAAAARc/y57FJha4pHIs0vm2v9DMJuKcS9PpEHyqQCK4B/s1600/wall3.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .centerCrop()
                .into(imageView);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("level_number", 4);
                getActivity().startActivity(i);
            }
        });

        return v;
    }

}