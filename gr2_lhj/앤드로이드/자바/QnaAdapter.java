package com.cookandroid.ezone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QnaAdapter extends RecyclerView.Adapter<QnaAdapter.ViewHolder> {
    ArrayList<Qna> items = new ArrayList<Qna>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.qna_list_item, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Qna item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Qna item) {
        items.add(item);
    }

    public void setItems(ArrayList<Qna> items) {
        this.items = items;
    }

    public Qna getItem(int position) {
        return items.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView3;


        public ViewHolder(View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.span1);
            textView3 = itemView.findViewById(R.id.span3);
        }

        public void setItem(Qna item) {
            textView1.setText(item.getTitle());

            textView3.setText(item.getDate().toString());
        }

    }

}
