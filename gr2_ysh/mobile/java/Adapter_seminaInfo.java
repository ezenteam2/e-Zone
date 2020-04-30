package com.example.ezone;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.net.URL;
import java.util.ArrayList;

public class Adapter_seminaInfo extends RecyclerView.Adapter<Adapter_seminaInfo.ViewHolder> {
    ArrayList<SeminarVO> items = new ArrayList<SeminarVO>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.unitsemi, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        SeminarVO item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(SeminarVO item) {
        items.add(item);
    }

    public void setItems(ArrayList<SeminarVO> items) {
        this.items = items;
    }

    public SeminarVO getItem(int position) {
        return items.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView subtitle;
        TextView subtitle_clone;
        TextView content;
        TextView price;
        TextView category;

        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            subtitle = itemView.findViewById(R.id.subtitle);
            subtitle_clone = itemView.findViewById(R.id.subtitle_clone);
            content = itemView.findViewById(R.id.content);
            price = itemView.findViewById(R.id.price);
            category = itemView.findViewById(R.id.category);

        }

        public void setItem(SeminarVO item) {
            title.setText(item.getSemiTitle());
            subtitle.setText(item.getSemiSubtitle());
            subtitle_clone.setText(item.getSemiSubtitle());
            content.setText(item.getSemiDetail());
            price.setText(item.getSemiPrice()+"원 /인");
            category.setText(item.getSemiCate());
        }

    }


}