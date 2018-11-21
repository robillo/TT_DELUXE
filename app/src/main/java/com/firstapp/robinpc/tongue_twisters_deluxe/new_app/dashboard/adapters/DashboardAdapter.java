package com.firstapp.robinpc.tongue_twisters_deluxe.new_app.dashboard.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firstapp.robinpc.tongue_twisters_deluxe.R;
import com.firstapp.robinpc.tongue_twisters_deluxe.new_app.data.LevelFigures;
import com.firstapp.robinpc.tongue_twisters_deluxe.new_app.utils.RetrieveLevelFigures;

import java.util.List;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.DashboardHolder> {

    private Context context;
    private List<LevelFigures> list;

    public DashboardAdapter(Context context, List<LevelFigures> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DashboardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DashboardHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.row_dashboard_plain, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardHolder holder, int position) {
        if(list.get(position).getLevelDrawable() == RetrieveLevelFigures.NULL_EQUIVALENT_DRAWABLE_ID) {
            holder.itemView.setVisibility(View.INVISIBLE);
            holder.levelImageView.setVisibility(View.GONE);
            holder.itemView.setClickable(false);
        }
        else {
            holder.levelNameTextView.setText(list.get(position).getLevelName());
            holder.levelHeaderTextView.setText(list.get(position).getLevelNumberHeader());
            Glide.with(context).load(list.get(position).getLevelDrawable())
                    .into(holder.levelImageView);
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class DashboardHolder extends RecyclerView.ViewHolder {

        ImageView levelImageView;
        TextView levelHeaderTextView, levelNameTextView;

        DashboardHolder(@NonNull View itemView) {
            super(itemView);
            levelImageView = itemView.findViewById(R.id.level_image);
            levelHeaderTextView = itemView.findViewById(R.id.level_number);
            levelNameTextView = itemView.findViewById(R.id.level_name);
        }
    }
}
