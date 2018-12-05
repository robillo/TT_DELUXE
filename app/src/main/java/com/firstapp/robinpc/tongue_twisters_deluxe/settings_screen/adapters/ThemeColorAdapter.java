package com.firstapp.robinpc.tongue_twisters_deluxe.settings_screen.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firstapp.robinpc.tongue_twisters_deluxe.R;
import com.firstapp.robinpc.tongue_twisters_deluxe.data.ThemeColorItem;
import com.firstapp.robinpc.tongue_twisters_deluxe.settings_screen.ThemeChangeListener;

import java.util.List;

public class ThemeColorAdapter extends RecyclerView.Adapter<ThemeColorAdapter.ThemeColorHolder> {

    private Context context;
    private ThemeChangeListener themeChangeListener;
    private List<ThemeColorItem> themeColorItems;

    public ThemeColorAdapter(Context context, List<ThemeColorItem> themeColorItems, ThemeChangeListener themeChangeListener) {
        this.context = context;
        this.themeColorItems = themeColorItems;
        this.themeChangeListener = themeChangeListener;
    }

    @NonNull
    @Override
    public ThemeColorHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ThemeColorHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.row_theme_color, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ThemeColorHolder themeColorHolder, final int position) {

        @SuppressWarnings("UnnecessaryLocalVariable") final int finalPosition = position;

        themeColorHolder.themeColorCard.setCardBackgroundColor(
                ContextCompat.getColor(
                        context,
                        themeColorItems.get(position).getColorToDisplay()
                )
        );
        themeColorHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                themeChangeListener.handleThemeChange(themeColorItems.get(finalPosition).getColorName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return themeColorItems == null ? 0 : themeColorItems.size();
    }

    class ThemeColorHolder extends RecyclerView.ViewHolder {

        CardView themeColorCard;

        ThemeColorHolder(@NonNull View itemView) {
            super(itemView);
            themeColorCard = itemView.findViewById(R.id.theme_color_card);
        }
    }
}
