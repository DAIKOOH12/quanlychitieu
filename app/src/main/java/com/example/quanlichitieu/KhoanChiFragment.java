package com.example.quanlichitieu;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quanlichitieu.databinding.FragmentKhoanChiBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KhoanChiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KhoanChiFragment extends Fragment{
    FragmentKhoanChiBinding binding;
    public KhoanChiFragment() {
        // Required empty public constructor
    }

    public static KhoanChiFragment newInstance(String param1, String param2) {
        KhoanChiFragment fragment = new KhoanChiFragment();
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
        binding=FragmentKhoanChiBinding.inflate(getLayoutInflater());
        ArrayList<KhoanChi> arrKhoanChi=new ArrayList<>();
        KhoanChi khoanChi1=new KhoanChi(1,"Ăn vặt",300000);
        KhoanChi khoanChi2=new KhoanChi(2,"Ăn liên hoan",500000);
        KhoanChi khoanChi3=new KhoanChi(3,"Ăn đám cưới",300000);

        arrKhoanChi.add(khoanChi1);
        arrKhoanChi.add(khoanChi2);
        arrKhoanChi.add(khoanChi3);

        CustomAdapterKhoanChi customAdapterKhoanChi=new CustomAdapterKhoanChi(this.getContext(),R.layout.row_items_khoan_chi,arrKhoanChi);
        binding.lvKhoanChi.setAdapter(customAdapterKhoanChi);
        addKhoanChi();
        return binding.getRoot();
    }
    public void addKhoanChi(){
        binding.iconAddKhoanChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),AddKhoanChi.class);
                startActivity(intent);
            }
        });
    }
}