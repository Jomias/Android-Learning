package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ManHinh2 extends AppCompatActivity {
    Button buttonBack;
    TextView textViewKq;
    String a, b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh2);
        buttonBack = findViewById(R.id.buttonBack);
        textViewKq = findViewById(R.id.textViewKq);

        // lay intent
        Intent intent = getIntent();

        // lay du lieu bang getStringExtra
        a = intent.getStringExtra("S1");
        b = intent.getStringExtra("S2");
        int s = Integer.parseInt(a) + Integer.parseInt(b);
        textViewKq.setText(String.valueOf(s));

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ManHinh2.this, MainActivity.class);
                intent1.putExtra("SoA", a);
                intent1.putExtra("SoB", b);
                intent1.putExtra("KQ", String.valueOf(s));
                startActivity(intent1);
            }
        });
    }
}