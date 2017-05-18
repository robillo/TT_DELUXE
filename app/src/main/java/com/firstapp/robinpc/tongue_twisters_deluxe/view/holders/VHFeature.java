package com.firstapp.robinpc.tongue_twisters_deluxe.view.holders;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firstapp.robinpc.tongue_twisters_deluxe.R;
import com.firstapp.robinpc.tongue_twisters_deluxe.view.activities.YourActivity;

public class VHFeature extends RecyclerView.ViewHolder{

    public ImageView photo;
    public TextView header;
    public CardView cardView;
    private Context context;

    public VHFeature(View itemView) {
        super(itemView);
        context = itemView.getContext();
        photo = (ImageView) itemView.findViewById(R.id.image);
        header = (TextView) itemView.findViewById(R.id.text);
        cardView = (CardView) itemView.findViewById(R.id.cardView);
    }

    public void intent(int position){
        switch (position){
            case 1:{
                context.startActivity(new Intent(context, YourActivity.class));
                break;
            }
            case 2:{
                Intent i = new Intent();
                i.setAction(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_TEXT, "Hey, Check out this exciting App at: https://play.google.com/store/apps/details?id=com.firstapp.robinpc.tongue_twisters_deluxe");
                i.setType("text/plain");
                context.startActivity(i);
                break;
            }
            case 3:{
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.firstapp.robinpc.tongue_twisters_deluxe"));
                context.startActivity(i);
                break;
            }
        }
    }
}
