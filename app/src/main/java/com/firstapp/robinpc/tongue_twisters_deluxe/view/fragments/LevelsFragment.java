package com.firstapp.robinpc.tongue_twisters_deluxe.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.firstapp.robinpc.tongue_twisters_deluxe.R;

import butterknife.BindView;

public class LevelsFragment extends Fragment {

    TextView levelTV, levelHeaderTV;
    ImageView Photo;

    public LevelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_levels, container, false);

        levelTV = (TextView) v.findViewById(R.id.level);
        levelHeaderTV = (TextView) v.findViewById(R.id.level_header);
        Photo = (ImageView) v.findViewById(R.id.imageView);

        Bundle args = getArguments();
        setPlayground(args);

        return v;
    }

    private void setPlayground(Bundle args){
        String Level = args.getString("level");
        Log.e("TEST", Level);
        String levelHeader = args.getString("levelHeader");
        Log.e("TEST", levelHeader);
        String photoUrl = args.getString("photoUrl");
        Log.e("TEST", photoUrl);

        levelTV.setText(Level);
        levelHeaderTV.setText(levelHeader);
        Glide.with(this)
                .load(photoUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .centerCrop()
                .into(Photo);
    }
}
