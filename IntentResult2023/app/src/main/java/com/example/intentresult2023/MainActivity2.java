package com.example.intentresult2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textViewNhan;
    Button buttonTinh;
    Intent intent;
    int a, b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        inItWidgets();
        buttonTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int c = a + b;
                intent.putExtra("tong", c);
                //danh dua ket qua tra ve
                setResult(33, intent);
                //phai dong man hinh bang lenh finish
                finish();
            }
        });
    }

    private void inItWidgets() {
        textViewNhan = findViewById(R.id.textViewNhan);
        buttonTinh = findViewById(R.id.buttonTinh);
        intent = getIntent();
        a = intent.getIntExtra("a", 0);
        b = intent.getIntExtra("b", 0);
        textViewNhan.setText("a=" + a + ", b=" + b);

    }
}