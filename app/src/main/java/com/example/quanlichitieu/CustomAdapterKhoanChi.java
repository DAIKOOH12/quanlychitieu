package com.example.quanlichitieu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.helper.widget.Layer;

import java.text.NumberFormat;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapterKhoanChi extends ArrayAdapter<KhoanChi> {
    private Context context;
    private int resource;
    private ArrayList<KhoanChi> arrKhoanChi;
    public CustomAdapterKhoanChi(@NonNull Context context, int resource, @NonNull ArrayList<KhoanChi> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.arrKhoanChi=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.row_items_khoan_chi,parent,false);

            viewHolder=new ViewHolder();
            viewHolder.tvNameChi=convertView.findViewById(R.id.tvNameChi);
            viewHolder.tvCostChi=convertView.findViewById(R.id.tvCostChi);

            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }

        KhoanChi khoanChi=arrKhoanChi.get(position);
        viewHolder.tvNameChi.setText(khoanChi.getsKhoanChi());

        NumberFormat numberFormat=NumberFormat.getNumberInstance();
        String formattedNumber=numberFormat.format(khoanChi.getlCostChi());
        viewHolder.tvCostChi.setText(formattedNumber+" VND");
        return convertView;
    }
    public class ViewHolder{
        TextView tvNameChi;
        TextView tvCostChi;
    }
}
