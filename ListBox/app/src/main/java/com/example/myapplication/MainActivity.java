package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listViewMonHoc;
    EditText editText1;
    Button btnOK;

    Spinner spinnerMonHoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = (EditText) findViewById(R.id.editText1);
        btnOK = (Button) findViewById(R.id.btnOK);
        listViewMonHoc = (ListView) findViewById(R.id.listViewMonHoc);
        ArrayList<String> arrayListMonHoc = new ArrayList<>();
        arrayListMonHoc.add("Java");
        arrayListMonHoc.add("Android");
        arrayListMonHoc.add("Database");
        arrayListMonHoc.add("Website");
        arrayListMonHoc.add("Computer");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_expandable_list_item_1,arrayListMonHoc);
        listViewMonHoc.setAdapter(adapter);
        listViewMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,arrayListMonHoc.get(i),Toast.LENGTH_SHORT).show();
            }
        });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editText1.getText().toString();
                arrayListMonHoc.add(s);
                adapter.notifyDataSetChanged();
                editText1.setText("");
                editText1.requestFocus();
            }
        });

        spinnerMonHoc = findViewById(R.id.spinnerMonHoc);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item, arrayListMonHoc);
        spinnerMonHoc.setAdapter(adapter1);
    }

    public void Init() {

    }
}