package com.example.student.demo;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NhanVienArrayAdapter extends ArrayAdapter<NhanVien> {

    Activity context; // màn hình muốn sử dụng adapter này
    int resource; // item layout cho list view
    ArrayList<NhanVien> objects;

    public NhanVienArrayAdapter(Activity context, int resource, ArrayList<NhanVien> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }
    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater(); // đọc file layout xml thành object
        View row = inflater.inflate(this.resource, null);
        ImageView imageView = row.findViewById(R.id.imageView);
        TextView textViewDetailNV = row.findViewById(R.id.textViewDetailNV);

        final NhanVien nhanVien = this.objects.get(position);
        if (nhanVien.isGioiTinhNam()){
            imageView.setImageResource(R.drawable.icons8_manager_48px);
        } else {
            imageView.setImageResource(R.drawable.icons8_kim_kardashian_48px);
        }
        textViewDetailNV.setText(nhanVien.toString());

        return row;
    }
}

