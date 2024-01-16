package com.example.quanlichitieu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterLoaiThu extends ArrayAdapter<LoaiThu> {
    private Context context;
    private int resource;
    private ArrayList<LoaiThu> arrLoaiThu;
    public CustomAdapterLoaiThu(@NonNull Context context, int resource, @NonNull ArrayList<LoaiThu> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.arrLoaiThu=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.row_items_thu,parent,false);

            viewHolder=new ViewHolder();
            viewHolder.tvTypeThu=convertView.findViewById(R.id.tvTypeThu);

            convertView.setTag(viewHolder);
        }
        else{
            viewHolder= (ViewHolder) convertView.getTag();
        }

        LoaiThu loaiThu=arrLoaiThu.get(position);
        viewHolder.tvTypeThu.setText(loaiThu.getsLoaiThu());
        return convertView;
    }
    public class ViewHolder{
        TextView tvTypeThu;
    }
}
