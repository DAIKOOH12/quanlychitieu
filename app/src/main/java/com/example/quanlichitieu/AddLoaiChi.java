package com.example.quanlichitieu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.quanlichitieu.databinding.ActivityAddLoaiChiBinding;

public class AddLoaiChi extends AppCompatActivity {
    ActivityAddLoaiChiBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddLoaiChiBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        binding.btnAddLoaiChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.btnCloseLoaiChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}