package com.example.intentbuoi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextHoTen, editTextNgaySinh;
    RadioButton rdoNam, rdoNu;
    CheckBox cbTheThao, cbDuLich;
    Spinner spQuocTich;
    Button btnSendBundle, btnSendObject, btnObjectBundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initwidgets();
        ArrayList<String> arrayListQuocTich = new ArrayList<>();
        arrayListQuocTich.add("VN");
        arrayListQuocTich.add("HQ");
        arrayListQuocTich.add("USA");
        arrayListQuocTich.add("UK");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, arrayListQuocTich);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spQuocTich.setAdapter(adapter);
        btnSendBundle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putString("HoTen", editTextHoTen.getText().toString());
                bundle.putString("NgaySinh", editTextNgaySinh.getText().toString());
                bundle.putString("GioiTinh", rdoNu.isChecked() ? "Nu" : "Nam");
                String soThich = "";
                if(cbTheThao.isChecked()) {
                    soThich += " " + cbTheThao.getText().toString();
                }
                if(cbDuLich.isChecked()) {
                    soThich += " " + cbDuLich.getText().toString();
                }
                bundle.putString("QuocTich", spQuocTich.getSelectedItem().toString());
                bundle.putString("SoThich", soThich);
                intent.putExtra("MyBundle", bundle);
                startActivity(intent);
            }
        });
        btnSendObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                // doi tuong thi bundle put Serialize
                intent.putExtra("SinhVien", new SinhVien(201240331, spQuocTich.getSelectedItem().toString()));
                String HT = editTextHoTen.getText().toString();
                Integer NS = Integer.parseInt(editTextNgaySinh.getText().toString());
                intent.putExtra("HT", HT);
                intent.putExtra("NS", NS);
                startActivity(intent);
            }
        });

        btnObjectBundle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putString("HT", editTextHoTen.getText().toString());
                bundle.putInt("NS", Integer.parseInt(editTextNgaySinh.getText().toString()));
                bundle.putSerializable("SinhVien", new SinhVien(201240331,
                        spQuocTich.getSelectedItem().toString()));
                intent.putExtra("MyBundle", bundle);
                startActivity(intent);
            }
        });
    }

    private void Initwidgets() {
        editTextHoTen = findViewById(R.id.editTextHoTen);
        editTextNgaySinh = findViewById(R.id.editTextNgaySinh);
        rdoNam = findViewById(R.id.rdoNam);
        rdoNu = findViewById(R.id.rdoNu);
        cbTheThao = findViewById(R.id.cbTheThao);
        cbDuLich = findViewById(R.id.cbDuLich);
        spQuocTich = findViewById(R.id.spQuocTich);
        btnSendBundle = findViewById(R.id.btnSendBundle);
        btnSendObject = findViewById(R.id.btnSendObject);
        btnObjectBundle = findViewById(R.id.btnObjectBundle);

    }
}