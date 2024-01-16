package com.example.quanlichitieu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.quanlichitieu.databinding.FragmentAccountBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment#} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {
    FragmentAccountBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentAccountBinding.inflate(getLayoutInflater());
        logOut();
        changePassWord();
        return binding.getRoot();
    }
    public void logOut(){
        binding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btnLogout.setAlpha(0.5f);
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.btnLogout.setAlpha(1);
                        Intent intent=new Intent(getActivity(),Login.class);
                        startActivity(intent);
                        getActivity().finish();
                    }
                },100);
            }
        });
    }
    public void changePassWord(){
        binding.tvChangePassWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ChangPassword.class);
                startActivity(intent);
            }
        });
    }
}