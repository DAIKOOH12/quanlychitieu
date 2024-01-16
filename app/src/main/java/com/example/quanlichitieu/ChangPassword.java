package com.example.quanlichitieu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.quanlichitieu.databinding.ActivityChangPasswordBinding;

public class ChangPassword extends AppCompatActivity {
    ActivityChangPasswordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityChangPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        overridePendingTransition(R.anim.right_to_left,R.anim.stable);
        showPassWord();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.stable,R.anim.left_to_right);
    }
    public void showPassWord(){
        binding.cbShow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    binding.edOldPass.setInputType(InputType.TYPE_CLASS_TEXT);
                    binding.edNewPass.setInputType(InputType.TYPE_CLASS_TEXT);
                    binding.edRePass.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                else {
                    binding.edOldPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    binding.edNewPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    binding.edRePass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }
}