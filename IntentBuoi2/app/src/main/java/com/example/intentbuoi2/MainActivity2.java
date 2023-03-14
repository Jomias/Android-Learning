package com.example.intentbuoi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    String HoTen, NgaySinh, GioiTinh, QuocTich, SoThich;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getBundleExtra("MyBundle");
        String HT = bundle.getString("HT");
        int NS = bundle.getInt("NS");
        SinhVien sv = (SinhVien) bundle.getSerializable("SinhVien");
        String s = HT + " " + NS + " " + sv;
        Toast.makeText(MainActivity2.this, s, Toast.LENGTH_SHORT).show();
//        Intent intent = getIntent();
//        String HT = intent.getStringExtra("HT");
//        int NS = intent.getIntExtra("NS", 0);
//        SinhVien sv = (SinhVien) intent.getSerializableExtra("SinhVien");
//        String s = HT + " " + NS + "\n" + sv;
//        Toast.makeText(MainActivity2.this, s, Toast.LENGTH_SHORT).show();

//        Bundle bundle = intent.getBundleExtra("MyBundle");
//        HoTen = bundle.getString("HoTen");
//        NgaySinh = bundle.getString("NgaySinh");
//        GioiTinh = bundle.getString("GioiTinh");
//        QuocTich = bundle.getString("QuocTich");
//        SoThich = bundle.getString("SoThich");
//        String s = HoTen + " " + NgaySinh + " " + GioiTinh + " " + QuocTich + " " + SoThich;
//        Toast.makeText(MainActivity2.this, s, Toast.LENGTH_SHORT).show();
    }
}