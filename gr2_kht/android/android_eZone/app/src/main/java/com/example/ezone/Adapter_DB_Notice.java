package com.example.ezone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_DB_Notice extends RecyclerView.Adapter<Adapter_DB_Notice.ViewHolder> {
    ArrayList<Notice_VO> items = new ArrayList<Notice_VO>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.unit_notice, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Notice_VO item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Notice_VO item) {
        items.add(item);
    }

    public void setItems(ArrayList<Notice_VO> items) {
        this.items = items;
    }

    public Notice_VO getItem(int position) {
        return items.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.noti_title);
            textView2 = itemView.findViewById(R.id.noti_detail);
        }

        public void setItem(Notice_VO item) {
            textView.setText(item.getNoti_title());
            textView2.setText(item.getNoti_detail());
        }

    }

}