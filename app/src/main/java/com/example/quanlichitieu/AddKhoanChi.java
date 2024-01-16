package com.example.quanlichitieu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.quanlichitieu.databinding.ActivityAddKhoanChiBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class AddKhoanChi extends AppCompatActivity {
    ActivityAddKhoanChiBinding binding;
    final Calendar myCalendar=Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddKhoanChiBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        DatePickerDialog.OnDateSetListener date=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR,year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                updateLabel();
            }
        };
        binding.edDateKhoanChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(AddKhoanChi.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        binding.btnAddKhoanChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setLoaiChi();
        binding.btnCloseKhoanChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void updateLabel(){
        String myFormat="dd/MM/yyyy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        binding.edDateKhoanChi.setText(dateFormat.format(myCalendar.getTime()));
    }
    public void setLoaiChi(){
        ArrayList<String> arrLoaiChi=new ArrayList<>();
        String loaiChi1="Tiền ăn";
        String loaiChi2="Tiền quần áo";
        String loaiChi3="Tiền bệnh tật";

        arrLoaiChi.add(loaiChi1);
        arrLoaiChi.add(loaiChi2);
        arrLoaiChi.add(loaiChi3);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,arrLoaiChi);
        arrayAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        binding.spinnerLoaiChi.setAdapter(arrayAdapter);
    }
}