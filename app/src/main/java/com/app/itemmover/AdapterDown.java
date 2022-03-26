package com.app.itemmover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterDown extends RecyclerView.Adapter<AdapterDown.ViewHolder> {

    Context context;
    List<Item> list;
    onClickInterface onClickInterface;

    public AdapterDown(Context context, List<Item> list, onClickInterface onClickInterface) {
        this.context = context;
        this.list = list;
        this.onClickInterface = onClickInterface;
    }

    @NonNull
    @Override
    public AdapterDown.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDown.ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImageID());
        holder.textView.setText(list.get(position).getImageName());
        int pos = position;
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickInterface.setClick(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        ConstraintLayout constraintLayout;
        View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout = (ConstraintLayout) itemView.findViewById(R.id.itemTile);
            imageView = (ImageView) itemView.findViewById(R.id.itemImage);
            textView = (TextView) itemView.findViewById(R.id.itemName);
            view = itemView;
        }
    }
}
