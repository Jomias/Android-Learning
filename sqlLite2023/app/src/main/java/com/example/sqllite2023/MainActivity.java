package com.example.sqllite2023;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttonInsert, buttonDelete, buttonUpdate, buttonLoadAll, buttonSearch;
    EditText editTextID, editTextHoTen, editTextNamSinh;
    TextView textViewData;
    MyDBHelper dbHelper = new MyDBHelper(this);

    @Override
    protected void onStart() {
        super.onStart();
        dbHelper.openDB();
    }

    @Override
    protected void onStop() {
        super.onStop();
        dbHelper.closeDB();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inItWidgets();
        dbHelper = new MyDBHelper(MainActivity.this);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long resultAdd = dbHelper.Insert(editTextHoTen.getText().toString(),
                        Integer.parseInt(editTextNamSinh.getText().toString()));
                Toast.makeText(MainActivity.this, resultAdd == -1 ? "Error" : "Inserted",
                        Toast.LENGTH_SHORT).show();
            }
        });
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long resultUpdate = dbHelper.Update(Integer.parseInt(editTextID.getText().toString())
                        , editTextHoTen.getText().toString(),
                        Integer.parseInt(editTextNamSinh.getText().toString()));
                Toast.makeText(MainActivity.this, resultUpdate == -1 ? "Error" : "Updated",
                        Toast.LENGTH_SHORT).show();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                long resultDelete = dbHelper.Delete(Integer.parseInt(editTextID.getText().toString()));
                Toast.makeText(MainActivity.this, resultDelete == 0 ? "Error" : "Deleted",
                        Toast.LENGTH_SHORT).show();
            }
        });

        buttonLoadAll.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View view) {
                StringBuffer buffer = new StringBuffer();
                Cursor cursor = dbHelper.DisplayAll();
                for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
                    buffer.append(cursor.getString((cursor.getColumnIndex(MyDBHelper.getID()))));
                    buffer.append("-");
                    buffer.append(cursor.getString((cursor.getColumnIndex(MyDBHelper.getNAME()))));
                    buffer.append("-");
                    buffer.append(cursor.getString((cursor.getColumnIndex(MyDBHelper.getYEAROB()))));
                    buffer.append("\n");
                }
                textViewData.setText(buffer);
            }
        });

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View v) {
                StringBuffer buffer = new StringBuffer();
                Cursor cursor = dbHelper.Search(editTextHoTen.getText().toString());
                for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
                    buffer.append(cursor.getString((cursor.getColumnIndex(MyDBHelper.getID()))));
                    buffer.append("-");
                    buffer.append(cursor.getString((cursor.getColumnIndex(MyDBHelper.getNAME()))));
                    buffer.append("-");
                    buffer.append(cursor.getString((cursor.getColumnIndex(MyDBHelper.getYEAROB()))));
                    buffer.append("\n");
                }
                textViewData.setText(buffer);
            }
        });

    }

    public void inItWidgets() {
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonInsert = findViewById(R.id.buttonInsert);
        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonLoadAll = findViewById(R.id.buttonLoadAll);
        editTextID = findViewById(R.id.editTextID);
        editTextHoTen = findViewById(R.id.editTextHoTen);
        editTextNamSinh = findViewById(R.id.editTextNamSinh);
        textViewData = findViewById(R.id.textViewData);
        buttonSearch = findViewById(R.id.buttonSearch);
    }
}