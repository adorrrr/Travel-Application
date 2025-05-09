package com.example.mobileapp.Activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mobileapp.databinding.ProductBinding;
import com.bumptech.glide.Glide;


public class ProductActivity extends AppCompatActivity {
    ProductBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Get data passed from adapter (optional)
        String title = getIntent().getStringExtra("title");
        String imageUrl = getIntent().getStringExtra("image");
        String price = getIntent().getStringExtra("price");
        String address = getIntent().getStringExtra("address");

        // Populate views
        binding.titleTextView.setText(title);
        binding.priceTextView.setText("$" + price);
        binding.addressTextView.setText(address);

        Glide.with(this).load(imageUrl).into(binding.mainImage);

    }
}
