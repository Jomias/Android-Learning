package com.example.baitapintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ManHinh2 extends AppCompatActivity {
    Button btnBack;
    TextView textViewKq;
    String a, b, c, d, e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh2);
        btnBack = findViewById(R.id.btnBack);

        // lay intent
        Intent intent = getIntent();

        // lay du lieu bang getStringExtra
        a = intent.getStringExtra("HoTen");
        b = intent.getStringExtra("NgaySinh");
        c = intent.getStringExtra("GioiTinh");
        d = intent.getStringExtra("QuocTich");
        e = intent.getStringExtra("SoThich");

        String s = a + " " + b + " " + c + " " + d + " " + e;
        Toast.makeText(ManHinh2.this, s, Toast.LENGTH_LONG).show();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ManHinh2.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}