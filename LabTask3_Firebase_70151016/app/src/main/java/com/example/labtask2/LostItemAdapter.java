package com.example.labtask2;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LostItemAdapter extends RecyclerView.Adapter<LostItemAdapter.ViewHolder> {

    // used to tell MainActivity which card was tapped
    public interface OnItemClickListener {
        void onItemClick(LostItem item);
    }

    ArrayList<LostItem> list;
    OnItemClickListener listener;

    public LostItemAdapter(ArrayList<LostItem> list, OnItemClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView card;
        TextView tvItemName, tvType, tvLocation, tvContact, tvStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card = (CardView) itemView;
            tvItemName = itemView.findViewById(R.id.tvItemName);
            tvType = itemView.findViewById(R.id.tvType);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvContact = itemView.findViewById(R.id.tvContact);
            tvStatus = itemView.findViewById(R.id.tvStatus);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lost, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final LostItem item = list.get(position);

        holder.tvItemName.setText(item.getItemName());
        holder.tvType.setText(item.getType());
        holder.tvLocation.setText("Location: " + item.getLocation());
        holder.tvContact.setText("Contact: " + item.getContact());
        holder.tvStatus.setText(item.getStatus());

        // pink badge for Lost, mint badge for Found
        if (item.getType().equals("Lost")) {
            holder.tvType.setBackgroundResource(R.drawable.badge_lost);
        } else {
            holder.tvType.setBackgroundResource(R.drawable.badge_found);
        }

        // Returned cards turn grey
        if (item.getStatus().equals("Returned")) {
            holder.card.setCardBackgroundColor(Color.parseColor("#E0E0E0"));
        } else {
            holder.card.setCardBackgroundColor(Color.WHITE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
