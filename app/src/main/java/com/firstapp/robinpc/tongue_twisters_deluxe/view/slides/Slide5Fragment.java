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
public class Slide5Fragment extends Fragment {


    ImageView imageView1;
    Button detail;

    public Slide5Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_slide5, container, false);

        CardView cardView = (CardView) v.findViewById(R.id.cardView);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
        TextView level = (TextView) v.findViewById(R.id.level);
        level.setText(getResources().getString(R.string.slide_5_title));
        TextView level_header = (TextView) v.findViewById(R.id.level_header);
        level_header.setText(getResources().getString(R.string.slide_5_desc));

        Glide.with(this)
                .load("http://2.bp.blogspot.com/-VYU5OWGtee8/WRH6N-hvs0I/AAAAAAAAARE/T5Bc-heYbEQWyJ8UHQ2yY4x9JAtorNN3QCK4B/s1600/wall2.png")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .centerCrop()
                .into(imageView);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("level_number", 5);
                getActivity().startActivity(i);
            }
        });

        return v;
    }

}