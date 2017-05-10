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
import com.firstapp.robinpc.tongue_twisters_deluxe.view.activities.YourActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Slide11Fragment extends Fragment {

    public Slide11Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_slide11, container, false);

        CardView cardView = (CardView) v.findViewById(R.id.cardView);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
        TextView level = (TextView) v.findViewById(R.id.level);
        level.setText(getResources().getString(R.string.slide_11_title));
        TextView level_header = (TextView) v.findViewById(R.id.level_header);
        level_header.setText(getResources().getString(R.string.slide_11_desc));

        Glide.with(this)
                .load("https://1.bp.blogspot.com/-e3cvqWcBdhc/WJBgDvUM6BI/AAAAAAAAAFk/SOlb9rdvi7gm5iThWrCoH273_kn0rQo3gCLcB/s1600/ph2.png")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .centerCrop()
                .into(imageView);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), YourActivity.class);
                getActivity().startActivity(i);

            }
        });

        return v;
    }

}
