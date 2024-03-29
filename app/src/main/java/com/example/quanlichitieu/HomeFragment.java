package com.example.quanlichitieu;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.quanlichitieu.databinding.FragmentHomeBinding;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    private boolean isShown=false;
    private long lTongTien=1000000;

    //Định dạng lại kiểu số cho tổng tiền
    NumberFormat numberFormat=NumberFormat.getNumberInstance();
    String formattedNumber=numberFormat.format(lTongTien);
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(inflater,container,false);

        //Gán giá trị cho spinner
        ArrayAdapter<CharSequence> adapterMonth=ArrayAdapter.createFromResource(this.getActivity(),R.array.month, android.R.layout.simple_spinner_item);
        adapterMonth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerMonth.setAdapter(adapterMonth);
        ArrayAdapter<CharSequence> adapterYear=ArrayAdapter.createFromResource(this.getActivity(),R.array.year, android.R.layout.simple_spinner_item);
        adapterYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerYear.setAdapter(adapterYear);

        binding.tvTotalWallet.setText(formattedNumber+" đ");
        loadChart();
        showMoney();
        return binding.getRoot();
    }
    public void loadChart(){
        PieChart pieChart=binding.chart;
        ArrayList<PieEntry> entries=new ArrayList<>();

        entries.add(new PieEntry(60f,"Khoản thu"));
        entries.add(new PieEntry(40f,"Khoản chi"));

        PieDataSet pieDataSet=new PieDataSet(entries,"Các khoản chi tiêu");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        pieDataSet.setValueTextColor(Color.WHITE);

        PieData pieData=new PieData(pieDataSet);
        pieChart.setData(pieData);

        pieChart.getDescription().setEnabled(false);
        pieChart.animateXY(2000,2000);
        pieChart.invalidate();
    }
    public void showMoney(){
        binding.iconShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isShown==false){
                    binding.tvTongTien.setText(formattedNumber+" đ");
                    binding.iconShow.setImageResource(R.drawable.show_money);
                    isShown=true;
                }
                else {
                    binding.tvTongTien.setText("********");
                    binding.iconShow.setImageResource(R.drawable.unsee_icon);
                    isShown=false;
                }
            }
        });
    }
}