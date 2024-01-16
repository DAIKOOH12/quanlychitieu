package com.example.quanlichitieu;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.quanlichitieu.databinding.FragmentLoaiChiBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoaiChiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoaiChiFragment extends Fragment {
    FragmentLoaiChiBinding binding;
    public LoaiChiFragment() {
        // Required empty public constructor
    }

    public static LoaiChiFragment newInstance(String param1, String param2) {
        LoaiChiFragment fragment = new LoaiChiFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentLoaiChiBinding.inflate(getLayoutInflater());
        ArrayList<LoaiChi> arrLoaiChi=new ArrayList<>();
        LoaiChi lc1=new LoaiChi(1,"Tiền ăn");
        LoaiChi lc2=new LoaiChi(2,"Tiền học thêm");
        LoaiChi lc3=new LoaiChi(3,"Tiền sửa xe");
        LoaiChi lc4=new LoaiChi(4,"Tiền shopping");

        arrLoaiChi.add(lc1);
        arrLoaiChi.add(lc2);
        arrLoaiChi.add(lc3);
        arrLoaiChi.add(lc4);

        CustomAdapterLoaiChi customAdapterLoaiChi=new CustomAdapterLoaiChi(this.getContext(),R.layout.row_items_chi,arrLoaiChi);
        binding.lvLoaiChi.setAdapter(customAdapterLoaiChi);
        addLoaiChi();
        return binding.getRoot();
    }
    public void addLoaiChi(){
        binding.iconAddLoaiChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),AddLoaiChi.class);
                startActivity(intent);
            }
        });
    }
}