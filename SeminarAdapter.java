package com.cookandroid.ezone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SeminarAdapter extends RecyclerView.Adapter<SeminarAdapter.ViewHolder> {
    ArrayList<Seminar> items = new ArrayList<Seminar>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.semi_list_item, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Seminar item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Seminar item) {
        items.add(item);
    }

    public void setItems(ArrayList<Seminar> items) {
        this.items = items;
    }

    public Seminar getItem(int position) {
        return items.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;


        public ViewHolder(View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.span1);
            textView3 = itemView.findViewById(R.id.span3);
        }

        public void setItem(Seminar item) {
            textView1.setText(item.getSemiTitle());

            textView3.setText(item.getSemiDate().toString());
        }

    }

}
