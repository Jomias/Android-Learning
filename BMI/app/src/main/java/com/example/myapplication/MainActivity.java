package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText editcannang;
    EditText editchieucao;
    TextView textViewKQ;
    Button btnKQ;
    TextView textViewNotice;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editcannang = (EditText) findViewById(R.id.editcannang);
        editchieucao = (EditText) findViewById(R.id.editchieucao);
        textViewKQ = (TextView) findViewById(R.id.textViewKQ);
        textViewNotice = (TextView) findViewById(R.id.textViewNotice);
        imageView = (ImageView) findViewById(R.id.imageView);

        btnKQ = (Button) findViewById(R.id.btnKQ);
        btnKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double weight = Double.parseDouble(editcannang.getText().toString());
                double height = Double.parseDouble(editchieucao.getText().toString());
                double BMI = weight / (height * height);
                textViewKQ.setText(String.valueOf(BMI));
                String kq;
                if (BMI < 15){
                    kq = "Suy dinh duong";
                    imageView.setImageResource(R.drawable.sdd);
                }
                else if (BMI < 16){
                    kq = "Rat gay";
                    imageView.setImageResource(R.drawable.rg);
                }
                else if (BMI < 18.5){
                    kq = "Gay";
                    imageView.setImageResource(R.drawable.g);
                }
                else if (BMI < 25){
                    kq = "Binh thuong";
                    imageView.setImageResource(R.drawable.bt);
                }
                else if (BMI < 30){
                    kq = "Thua can";
                    imageView.setImageResource(R.drawable.tc);
                }
                else if (BMI < 35){
                    kq = "Beo phi do 1";
                    imageView.setImageResource(R.drawable.bp1);
                }
                else if (BMI < 40){
                    kq = "Beo phi do 2";
                    imageView.setImageResource(R.drawable.bp2);
                }
                else {
                    kq = "Beo phi do 3";
                    imageView.setImageResource(R.drawable.bp3);
                }
                textViewNotice.setText(kq);
            }
        });



    }
}