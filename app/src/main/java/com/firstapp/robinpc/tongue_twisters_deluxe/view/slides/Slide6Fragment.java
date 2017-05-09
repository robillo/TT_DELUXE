package com.firstapp.robinpc.tongue_twisters_deluxe.view.slides;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.firstapp.robinpc.tongue_twisters_deluxe.R;
import com.firstapp.robinpc.tongue_twisters_deluxe.view.activities.DetailActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Slide6Fragment extends Fragment {

    Button detail;
    ImageView imageView1;

    public Slide6Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_slide6, container, false);

        detail = (Button) v.findViewById(R.id.detail);
        imageView1 = (ImageView) v.findViewById(R.id.imageView1);
        Glide.with(this)
                .load("https://3.bp.blogspot.com/-wCIrRQkOkBI/WJBgD7IU0cI/AAAAAAAAAFo/TvEV52hMIdMrmPF2nYqe4rBt6MQl4hXzwCLcB/s1600/ph3.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .centerCrop()
                .into(imageView1);

        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("level_number", 6);
                getActivity().startActivity(i);
            }
        });

        return v;
    }

}
