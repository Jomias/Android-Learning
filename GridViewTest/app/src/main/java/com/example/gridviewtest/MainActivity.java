package com.example.gridviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<HinhAnh> arrayListHinhAnh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridView);
//        final String[] kyTu = new String[] {
//                "A", "B", "C", "D", "E", "F", "G",
//                "H", "I", "J", "K", "L", "M", "N",
//                "O", "P", "U", "R", "S", "T", "U", "V",
//                "W", "Y", "X", "Z"
//        };
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, kyTu);
//        gridView.setAdapter(adapter);
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, kyTu[i].toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
        arrayListHinhAnh = new ArrayList<>();
        arrayListHinhAnh.add(new HinhAnh("Anh 1", R.drawable.aa));
        arrayListHinhAnh.add(new HinhAnh("Anh 2", R.drawable.bb));
        arrayListHinhAnh.add(new HinhAnh("Anh 3", R.drawable.cc));
        arrayListHinhAnh.add(new HinhAnh("Anh 4", R.drawable.dd));
        HinhAnhAdapter adapter = new HinhAnhAdapter(MainActivity.this, R.layout.itemhinhanh, arrayListHinhAnh);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, arrayListHinhAnh.get(i).getTen().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}