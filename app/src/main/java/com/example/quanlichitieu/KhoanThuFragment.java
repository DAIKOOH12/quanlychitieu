package com.example.quanlichitieu;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quanlichitieu.databinding.FragmentKhoanThuBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KhoanThuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KhoanThuFragment extends Fragment {
    FragmentKhoanThuBinding binding;
    public KhoanThuFragment() {
        // Required empty public constructor
    }
    public static KhoanThuFragment newInstance(String param1, String param2) {
        KhoanThuFragment fragment = new KhoanThuFragment();
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
        binding=FragmentKhoanThuBinding.inflate(getLayoutInflater());

        ArrayList<KhoanThu> arrKhoanThu=new ArrayList<>();
        KhoanThu khoanThu1=new KhoanThu(1,"Lãi ngân hàng",300000);
        KhoanThu khoanThu2=new KhoanThu(2,"Lương cứng",14000000);
        KhoanThu khoanThu3=new KhoanThu(3,"Lãi thưởng",500000);
        KhoanThu khoanThu4=new KhoanThu(4,"Lãi cho vay",1000000);

        arrKhoanThu.add(khoanThu1);
        arrKhoanThu.add(khoanThu2);
        arrKhoanThu.add(khoanThu3);
        arrKhoanThu.add(khoanThu4);

        CustomAdapterKhoanThu customAdapterKhoanThu=new CustomAdapterKhoanThu(this.getContext(),R.layout.row_items_khoan_thu,arrKhoanThu);
        binding.lvKhoanThu.setAdapter(customAdapterKhoanThu);
        addKhoanThu();
        return binding.getRoot();
    }
    public void addKhoanThu(){
        binding.iconAddKhoanThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),AddKhoanThu.class);
                startActivity(intent);
            }
        });
    }
}