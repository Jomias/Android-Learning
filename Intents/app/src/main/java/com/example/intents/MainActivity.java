package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextSo1, editTextSo2;
    Button buttonSend;
    TextView textViewSo1, textViewSo2, textViewKq1;
    String a, b, c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initwidgets();
        // lay intent
        Intent intent = getIntent();

        // lay du lieu bang getStringExtra
        a = intent.getStringExtra("SoA");
        b = intent.getStringExtra("SoB");
        c = intent.getStringExtra("KQ");
        textViewSo1.setText(a);
        textViewSo2.setText(b);
        textViewKq1.setText(c);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String so1 = editTextSo1.getText().toString();
                String so2 = editTextSo2.getText().toString();
                // khai bao intent
                Intent intent1 = new Intent(MainActivity.this, ManHinh2.class);
                // dong goi du lieu vao intent
                intent1.putExtra("S1", so1);
                intent1.putExtra("S2", so2);
                startActivity(intent1);
            }
        });
    }

    private void Initwidgets() {
        editTextSo1 = findViewById(R.id.editTextSo1);
        editTextSo2 = findViewById(R.id.editTextSo2);
        buttonSend = findViewById(R.id.buttonSend);
        textViewSo1 = findViewById(R.id.textViewSo1);
        textViewSo2 = findViewById(R.id.textViewSo2);
        textViewKq1 = findViewById(R.id.textViewKq1);
    }
}