package com.example.mobileapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mobileapp.Activities.ProductActivity;
import com.example.mobileapp.Model.ItemModel;
import com.example.mobileapp.databinding.ViewholderPopularBinding;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.Viewholder> {

    private final ArrayList<ItemModel> items;
    private final Context context;

    public PopularAdapter(ArrayList<ItemModel> items, Context context) {
        this.items = items;
        this.context = context;
    }

    public PopularAdapter(Context context, ArrayList<ItemModel> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public PopularAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewholderPopularBinding binding = ViewholderPopularBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.Viewholder holder, int position) {
        ItemModel item = items.get(position);

        holder.binding.titleTxt.setText(item.getTitel());
        holder.binding.priceTxt.setText("$" + item.getPrice() + "/Night");
        holder.binding.addressTxt.setText(item.getAddress());
        holder.binding.scoreTxt.setText(String.valueOf(item.getScore()));

        Glide.with(context)
                .load(item.getPic().get(0))
                .into(holder.binding.pic);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, ProductActivity.class);
            intent.putExtra("title", item.getTitel()); // Fixed spelling from getTitle) to getTitle()
            intent.putExtra("image", item.getPic().get(0));
            intent.putExtra("price", String.valueOf(item.getPrice()));
            intent.putExtra("address", item.getAddress());
            context.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {
        ViewholderPopularBinding binding;

        public Viewholder(ViewholderPopularBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
