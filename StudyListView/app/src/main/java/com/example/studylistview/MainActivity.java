package com.example.studylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<SinhVien> arrayListSinhVien;
    ListView listViewSv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewSv = findViewById(R.id.listViewSv);
        arrayListSinhVien = new ArrayList<>();
        arrayListSinhVien.add(new SinhVien("Nguyen Van A", 2000, R.drawable.aa));
        arrayListSinhVien.add(new SinhVien("Nguyen Van B", 2001, R.drawable.bb));
        arrayListSinhVien.add(new SinhVien("Nguyen Van C", 2000, R.drawable.cc));
        arrayListSinhVien.add(new SinhVien("Nguyen Van D", 2002, R.drawable.dd));
        arrayListSinhVien.add(new SinhVien("Nguyen Van E", 1998, R.drawable.ee));
        SinhVienAdapter adapter = new SinhVienAdapter(MainActivity.this, R.layout.activity_list_item, arrayListSinhVien);
        listViewSv.setAdapter(adapter);
        listViewSv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SinhVien sv = arrayListSinhVien.get(i);
                Toast.makeText(MainActivity.this, sv.getHoTen() + "\n" + sv.getNamSinh().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}