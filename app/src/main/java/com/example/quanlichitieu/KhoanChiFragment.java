package com.example.quanlichitieu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quanlichitieu.databinding.FragmentKhoanChiBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KhoanChiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KhoanChiFragment extends Fragment {
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
        return binding.getRoot();
    }
}