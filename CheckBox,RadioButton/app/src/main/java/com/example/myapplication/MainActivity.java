package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTen;
    RadioButton rdoNam;
    RadioButton rdoNu;
    CheckBox cbTheThao;
    CheckBox cbDuLich;
    CheckBox cbDocSach;
    Button btnOK;
    TextView txtKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTen = (EditText) findViewById(R.id.editTen);
        rdoNam = (RadioButton) findViewById(R.id.rdoNam);
        rdoNu = (RadioButton) findViewById(R.id.rdoNu);
        cbTheThao = (CheckBox) findViewById(R.id.cbTheThao);
        cbDuLich = (CheckBox) findViewById(R.id.cbDuLich);
        cbDocSach = (CheckBox) findViewById(R.id.cbDocSach);
        txtKQ = (TextView) findViewById(R.id.txtKQ);

        btnOK = (Button) findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kq = "";
                kq = kq + editTen.getText().toString();
                if(rdoNam.isChecked()) {
                    kq += " " + rdoNam.getText().toString();
                }
                if(rdoNu.isChecked()) {
                    kq += " " + rdoNu.getText().toString();
                }
                if(cbTheThao.isChecked()) {
                    kq += " " + cbTheThao.getText().toString();
                }
                if(cbDuLich.isChecked()) {
                    kq += " " + cbDuLich.getText().toString();
                }
                if(cbDocSach.isChecked()) {
                    kq += " " + cbDocSach.getText().toString();
                }
                txtKQ.setText(kq);
                Toast.makeText(MainActivity.this,kq,Toast.LENGTH_SHORT).show();
            }
        });



    }
}