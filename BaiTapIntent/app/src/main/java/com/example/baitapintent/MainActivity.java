package com.example.baitapintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextHoTen, editTextNgaySinh;
    RadioButton rdoNam, rdoNu;
    CheckBox cbTheThao, cbDuLich;
    Spinner spQuocTich;
    Button btnSubmit;

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
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, arrayListQuocTich);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spQuocTich.setAdapter(adapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ManHinh2.class);
                intent.putExtra("HoTen", editTextHoTen.getText().toString());
                intent.putExtra("NgaySinh", editTextNgaySinh.getText().toString());
                intent.putExtra("GioiTinh", rdoNu.isChecked() ? "Nu" : "Nam");
                String soThich = "";
                if(cbTheThao.isChecked()) {
                    soThich += " " + cbTheThao.getText().toString();
                }
                if(cbDuLich.isChecked()) {
                    soThich += " " + cbDuLich.getText().toString();
                }
                intent.putExtra("QuocTich", spQuocTich.getSelectedItem().toString());
                intent.putExtra("SoThich", soThich);
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
        btnSubmit = findViewById(R.id.btnSubmit);
    }
}