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
public class Slide9Fragment extends Fragment {

    ImageView imageView1;
    Button detail;

    public Slide9Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_slide9, container, false);

        detail = (Button) v.findViewById(R.id.detail);
        imageView1 = (ImageView) v.findViewById(R.id.imageView1);
        Glide.with(this)
                .load("https://4.bp.blogspot.com/-NEeESa_oEeQ/WIO2fJR2pSI/AAAAAAAAAC0/Ciz69at_-CAcTjQ561OPnhJyVOF2ITVvwCLcB/s1600/ten.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .centerCrop()
                .into(imageView1);

        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("level_number", 9);
                getActivity().startActivity(i);
            }
        });

        return v;
    }

}