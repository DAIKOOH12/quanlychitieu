package com.example.quanlichitieu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterLoaiChi extends ArrayAdapter<LoaiChi> {
    private Context context;
    private int resource;
    private ArrayList<LoaiChi> arrLoaiChi;
    public CustomAdapterLoaiChi(@NonNull Context context, int resource, @NonNull ArrayList<LoaiChi> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.arrLoaiChi=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.row_items_chi,parent,false);

            viewHolder=new ViewHolder();
            viewHolder.tvTypeChi=convertView.findViewById(R.id.tvTypeChi);

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();
        }

        LoaiChi loaiChi=arrLoaiChi.get(position);
        viewHolder.tvTypeChi.setText(loaiChi.getsLoaiChi());
        return convertView;
    }
    public class ViewHolder{
        TextView tvTypeChi;
    }
}
