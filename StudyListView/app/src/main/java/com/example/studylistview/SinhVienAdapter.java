package com.example.studylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    private final Context context;
    private final List<SinhVien> sinhVienList;
    private final int layout;

    public SinhVienAdapter(Context context, int layout, List<SinhVien> sinhVienList) {
        this.context = context;
        this.layout = layout;
        this.sinhVienList = sinhVienList;
    }

    @Override
    public int getCount() {
        return sinhVienList.size();
    }

    @Override
    public Object getItem(int i) {
        return sinhVienList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class ViewHolder {
        ImageView imgHinh;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.imgHinh = view.findViewById(R.id.imageViewAnh);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        SinhVien sv = (SinhVien) getItem(i);
        if (sv == null) {
            return view;
        }
        TextView textViewHoTen = view.findViewById(R.id.textViewHoTen);
        TextView textViewNamSinh = view.findViewById(R.id.textViewNamSinh);
        holder.imgHinh.setImageResource(sv.getHinh());
        textViewHoTen.setText(sv.getHoTen());
        textViewNamSinh.setText(String.valueOf(sv.getNamSinh()));
        return view;
    }
}
