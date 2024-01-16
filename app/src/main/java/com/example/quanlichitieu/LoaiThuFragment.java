package com.example.quanlichitieu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quanlichitieu.databinding.FragmentLoaiThuBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoaiThuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoaiThuFragment extends Fragment {
    FragmentLoaiThuBinding binding;
    public LoaiThuFragment() {
        // Required empty public constructor
    }
    public static LoaiThuFragment newInstance(String param1, String param2) {
        LoaiThuFragment fragment = new LoaiThuFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentLoaiThuBinding.inflate(getLayoutInflater());
        // Inflate the layout for this fragment
        ArrayList<LoaiThu> arrLoaiThu=new ArrayList<>();
        LoaiThu loaiThu1=new LoaiThu(1,"Tiền lương");
        LoaiThu loaiThu2=new LoaiThu(2,"Tiền lãi ngân hàng");
        LoaiThu loaiThu3=new LoaiThu(3,"Tiền lãi cho vay");
        LoaiThu loaiThu4=new LoaiThu(4,"Tiền đầu tư");

        arrLoaiThu.add(loaiThu1);
        arrLoaiThu.add(loaiThu2);
        arrLoaiThu.add(loaiThu3);
        arrLoaiThu.add(loaiThu4);


        CustomAdapterLoaiThu customAdapterLoaiThu=new CustomAdapterLoaiThu(this.getContext(),R.layout.row_items_thu,arrLoaiThu);
        binding.lvLoaiThu.setAdapter(customAdapterLoaiThu);
        return binding.getRoot();
    }
}