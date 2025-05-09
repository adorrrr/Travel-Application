package com.example.mobileapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.mobileapp.Model.CategoryModel;
import com.example.mobileapp.databinding.ViewholdeerCategoryBinding;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Viewholder> {

    private final List<CategoryModel> items;
    private Context context;

    public CategoryAdapter(List<CategoryModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CategoryAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();


        ViewholdeerCategoryBinding binding = ViewholdeerCategoryBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
        );

        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.Viewholder holder, int position) {
        CategoryModel item = items.get(position);
        holder.binding.title.setText(item.getName());


        Glide.with(context)
                .load(item.getImagePath())
                .into(holder.binding.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {
        private final ViewholdeerCategoryBinding binding;

        public Viewholder(ViewholdeerCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
