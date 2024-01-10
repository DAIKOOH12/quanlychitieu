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

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(inflater,container,false);
        ArrayAdapter<CharSequence> adapterMonth=ArrayAdapter.createFromResource(this.getActivity(),R.array.month, android.R.layout.simple_spinner_item);
        adapterMonth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerMonth.setAdapter(adapterMonth);
        ArrayAdapter<CharSequence> adapterYear=ArrayAdapter.createFromResource(this.getActivity(),R.array.year, android.R.layout.simple_spinner_item);
        adapterYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerYear.setAdapter(adapterYear);
        loadChart();
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
}