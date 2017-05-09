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
public class Slide3Fragment extends Fragment {

    ImageView imageView1;
    Button detail;

    public Slide3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_slide3, container, false);

        imageView1 = (ImageView) v.findViewById(R.id.imageView1);
        detail = (Button) v.findViewById(R.id.detail);
        Glide.with(this)
                .load("https://1.bp.blogspot.com/-OYwFn64dzV0/WJBfWvYaXaI/AAAAAAAAAFc/1egquqeEF30HrOgarJflAGp8fXqyBeKDQCLcB/s1600/ph4.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .centerCrop()
                .into(imageView1);

        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("level_number", 3);
                getActivity().startActivity(i);
            }
        });

        return v;
    }

}