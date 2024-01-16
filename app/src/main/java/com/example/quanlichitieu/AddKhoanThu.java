package com.example.quanlichitieu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;

import com.example.quanlichitieu.databinding.ActivityAddKhoanThuBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class AddKhoanThu extends AppCompatActivity {
    ActivityAddKhoanThuBinding binding;
    final Calendar myCalendar=Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddKhoanThuBinding.inflate(getLayoutInflater());
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
        binding.edDateKhoanThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(AddKhoanThu.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        binding.btnAddKhoanThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setLoaiThu();
        binding.btnCloseKhoanThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void updateLabel(){
        String myFormat="dd/MM/yyyy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        binding.edDateKhoanThu.setText(dateFormat.format(myCalendar.getTime()));
    }
    public void setLoaiThu(){
        ArrayList<String> arrLoaiThu=new ArrayList<>();
        String loaiThu1="Lãi ngân hàng";
        String loaiThu2="Lương cứng";
        String loaiThu3="Lương thưởng";

        arrLoaiThu.add(loaiThu1);
        arrLoaiThu.add(loaiThu2);
        arrLoaiThu.add(loaiThu3);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,arrLoaiThu);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.spinnerLoaiThu.setAdapter(arrayAdapter);
    }
}