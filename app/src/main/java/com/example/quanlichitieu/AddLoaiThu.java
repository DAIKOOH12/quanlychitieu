package com.example.quanlichitieu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.quanlichitieu.databinding.ActivityAddLoaiThuBinding;

public class AddLoaiThu extends AppCompatActivity {
    ActivityAddLoaiThuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddLoaiThuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAddLoaiThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.btnCloseLoaiThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}