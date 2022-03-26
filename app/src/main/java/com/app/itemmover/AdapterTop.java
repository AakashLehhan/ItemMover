package com.app.itemmover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterTop extends RecyclerView.Adapter<AdapterTop.ViewHolder> {

    Context context;
    List<Item> list;

    public AdapterTop(Context context, List<Item> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterTop.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.rv_item, parent, false);
        return new AdapterTop.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTop.ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImageID());
        holder.textView.setText(list.get(position).getImageName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.itemImage);
            textView = (TextView) itemView.findViewById(R.id.itemName);
            view = itemView;
        }
    }
}
