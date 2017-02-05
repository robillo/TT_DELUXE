package com.firstapp.robinpc.tongue_twisters_deluxe.model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firstapp.robinpc.tongue_twisters_deluxe.R;
import com.firstapp.robinpc.tongue_twisters_deluxe.controller.ItemClickListener;
import com.firstapp.robinpc.tongue_twisters_deluxe.view.AddActivity;
import com.firstapp.robinpc.tongue_twisters_deluxe.view.DetailActivity;
import com.firstapp.robinpc.tongue_twisters_deluxe.controller.MyDBHelper;

public class View_Holder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener /*, View.OnCreateContextMenuListener*/{

    public CardView cardView;
    public TextView Title;
    public TextView subTitle;
    private ItemClickListener clickListener;
    Context context;

    public View_Holder(View itemView) {
        super(itemView);
        cardView= (CardView) itemView.findViewById(R.id.cardView);
        Title= (TextView) itemView.findViewById(R.id.Title);
        subTitle= (TextView) itemView.findViewById(R.id.subTitle);

        context = itemView.getContext();
        itemView.setTag(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
        /*itemView.setOnCreateContextMenuListener(this);*/
    }

    public void setClickListener(ItemClickListener itemClickListener){
        this.clickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        clickListener.onClick(view, getAdapterPosition(),false);
    }

    @Override
    public boolean onLongClick(View view) {
        clickListener.onClick(view, getAdapterPosition(), true);
        return true;
    }

    public void intent(String Title, String subTitle, String TT){
        Intent i = new Intent(context, DetailActivity.class);
        i.putExtra("Title", Title);
        i.putExtra("subTitle", subTitle);
        i.putExtra("TT", TT);
        context.startActivity(i);
    }

    public void intentAdd(String Title, String subTitle, String TT){
        Intent i = new Intent(context, AddActivity.class);
        i.putExtra("Title", Title);
        i.putExtra("subTitle", subTitle);
        i.putExtra("TT", TT);
        context.startActivity(i);
    }

    public void deleteTwister(int position){
        MyDBHelper myDBHelper = new MyDBHelper(context);
        myDBHelper.deleteTwister(position-1);
    }

    /*
    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View v, ContextMenu.ContextMenuInfo contextMenuInfo) {
        contextMenu.setHeaderTitle("Pick An Action");
        contextMenu.add(Menu.NONE, R.id.edit_t, Menu.NONE, "Edit Twister");//groupId, itemId, order, title
        contextMenu.add(Menu.NONE, R.id.delete_t, Menu.NONE, "Delete Twistr");
    }*/
}
