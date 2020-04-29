package com.example.ezone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_qna extends RecyclerView.Adapter<Adapter_qna.ViewHolder> {
    ArrayList<Qna_VO> items = new ArrayList<Qna_VO>();

    @NonNull
    @Override
    public Adapter_qna.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.unit_qna, viewGroup, false);

        return new Adapter_qna.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_qna.ViewHolder viewHolder, int position) {
        Qna_VO item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Qna_VO item) {
        items.add(item);
    }

    public void setItems(ArrayList<Qna_VO> items) {
        this.items = items;
    }

    public Qna_VO getItem(int position) {
        return items.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;
        TextView textView3;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.qna_cate);
            textView2 = itemView.findViewById(R.id.qna_title);
            textView3 = itemView.findViewById(R.id.qna_detail);
        }

        public void setItem(Qna_VO item) {
            textView.setText(item.getQnaCate());
            textView2.setText(item.getQnaTitle());
            textView3.setText(item.getQnaDetail());
        }

    }

}