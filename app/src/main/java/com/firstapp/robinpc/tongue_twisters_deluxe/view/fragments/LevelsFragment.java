package com.firstapp.robinpc.tongue_twisters_deluxe.view.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.firstapp.robinpc.tongue_twisters_deluxe.R;
import com.firstapp.robinpc.tongue_twisters_deluxe.view.activities.DetailActivity;

public class LevelsFragment extends Fragment {

    private TextView levelTV, levelHeaderTV;
    private ImageView Photo;
    private CardView cardView;
    private int levelNumber;

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
        cardView = (CardView) v.findViewById(R.id.cardView);

        Bundle args = getArguments();
        setPlayground(args);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("level_number", levelNumber);
                getActivity().startActivity(i);
            }
        });

        return v;
    }

    private void setPlayground(Bundle args){
        if(args!=null){
            String Level = args.getString("level");
            String levelHeader = args.getString("levelHeader");
            String photoUrl = args.getString("photoUrl");
            levelNumber = args.getInt("levelNumber");

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
}
