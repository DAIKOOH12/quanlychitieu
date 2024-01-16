package com.example.quanlichitieu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapterKhoanThu extends ArrayAdapter<KhoanThu> {
    private Context context;
    private int resource;
    private ArrayList<KhoanThu> arrKhoanThu;
    public CustomAdapterKhoanThu(@NonNull Context context, int resource, @NonNull ArrayList<KhoanThu> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.arrKhoanThu=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.row_items_khoan_thu,parent,false);

            viewHolder=new ViewHolder();
            viewHolder.tvNameThu=convertView.findViewById(R.id.tvNameThu);
            viewHolder.tvCostThu=convertView.findViewById(R.id.tvCostThu);

            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }

        KhoanThu khoanThu=arrKhoanThu.get(position);
        viewHolder.tvNameThu.setText(khoanThu.getsKhoanThu());

        NumberFormat numberFormat=NumberFormat.getNumberInstance();
        String formattedNumber=numberFormat.format(khoanThu.getlCostThu());
        viewHolder.tvCostThu.setText(formattedNumber+" VND");
        return convertView;
    }
    public class ViewHolder{
        TextView tvNameThu;
        TextView tvCostThu;
    }
}
