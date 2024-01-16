package com.example.quanlichitieu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.quanlichitieu.databinding.FragmentThuBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThuFragment#} factory method to
 * create an instance of this fragment.
 */
public class ThuFragment extends Fragment {
    FragmentThuBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentThuBinding.inflate(getLayoutInflater());
        setTab();
        return binding.getRoot();
    }
    public void setTab() {
        binding.tvKhoanThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.tvKhoanThu.getBackground() == null && binding.tvLoaiThu.getBackground() != null) {
                    binding.tvKhoanThu.setBackgroundResource(R.drawable.bottom_line);
                    binding.tvLoaiThu.setBackgroundDrawable(null);
                    FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                    KhoanThuFragment khoanThuFragment=new KhoanThuFragment();
                    fragmentTransaction.replace(R.id.frag_thu,khoanThuFragment);
                    fragmentTransaction.commit();
                }
            }
        });
        binding.tvLoaiThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.tvLoaiThu.getBackground() == null && binding.tvKhoanThu.getBackground() != null) {
                    binding.tvLoaiThu.setBackgroundResource(R.drawable.bottom_line);
                    binding.tvKhoanThu.setBackgroundDrawable(null);
                    FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                    LoaiThuFragment loaiThuFragment=new LoaiThuFragment();
                    fragmentTransaction.replace(R.id.frag_thu,loaiThuFragment);
                    fragmentTransaction.commit();
                }
            }
        });
    }
}