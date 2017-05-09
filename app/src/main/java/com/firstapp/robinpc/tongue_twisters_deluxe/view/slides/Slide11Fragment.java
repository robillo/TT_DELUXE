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
import com.firstapp.robinpc.tongue_twisters_deluxe.view.activities.YourActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class Slide11Fragment extends Fragment {


    ImageView imageView1;
    Button detail;

    public Slide11Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_slide11, container, false);

        imageView1 = (ImageView) v.findViewById(R.id.imageView1);
        detail = (Button) v.findViewById(R.id.detail);
        Glide.with(this)
                .load("https://3.bp.blogspot.com/-7Fbv9Mcj8Ho/WIo5cjN-EOI/AAAAAAAAAEM/CtwvYPu184goLOWknhMyxSg8eQX55EaCACLcB/s1600/5.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .centerCrop()
                .into(imageView1);

        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), YourActivity.class);
                getActivity().startActivity(i);

            }
        });

        return v;
    }

}
