package com.example.quanlichitieu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.quanlichitieu.databinding.FragmentChiBinding;
import com.example.quanlichitieu.databinding.FragmentHomeBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChiFragment#} factory method to
 * create an instance of this fragment.
 */
public class ChiFragment extends Fragment {
    FragmentChiBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentChiBinding.inflate(getLayoutInflater());
        setTab();
        return binding.getRoot();
    }

    public void setTab() {
        binding.tvKhoanChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.tvKhoanChi.getBackground() == null && binding.tvLoaiChi.getBackground() != null) {
                    binding.tvKhoanChi.setBackgroundResource(R.drawable.bottom_line);
                    binding.tvLoaiChi.setBackgroundDrawable(null);
                    FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                    KhoanChiFragment khoanChiFragment=new KhoanChiFragment();
                    fragmentTransaction.replace(R.id.frag_chi,khoanChiFragment);
                    fragmentTransaction.commit();
                }
            }
        });
        binding.tvLoaiChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.tvLoaiChi.getBackground() == null && binding.tvKhoanChi.getBackground() != null) {
                    binding.tvLoaiChi.setBackgroundResource(R.drawable.bottom_line);
                    binding.tvKhoanChi.setBackgroundDrawable(null);
                    FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                    LoaiChiFragment loaiChiFragment=new LoaiChiFragment();
                    fragmentTransaction.replace(R.id.frag_chi,loaiChiFragment);
                    fragmentTransaction.commit();
                }
            }
        });
    }
}