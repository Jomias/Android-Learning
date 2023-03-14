package com.example.dialogoption;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button buttonDelete, buttonLogin;
    TextView textViewTest;
    ArrayList<String> monHoc = new ArrayList<>();
    ArrayAdapter adapter;
    int val = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inits();
        monHoc.add("Java");
        monHoc.add("Android");
        monHoc.add("C#");
        monHoc.add("Network");
        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, monHoc);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, monHoc.get(i), Toast.LENGTH_SHORT).show();
                val = i;
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                xacNhanXoa();
                return false;
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(val == -1) {
                    return;
                }
                xacNhanXoa();
            }
        });
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog1();
            }
        });
    }

    private void mydialog1() {
        // khai báo dialog
        Dialog dialog = new Dialog(this);
        // gan layout
        dialog.setContentView(R.layout.mydialog);
        EditText editTextUsername = dialog.findViewById(R.id.editTextUsername);
        EditText editTextPassword = dialog.findViewById(R.id.editTextPassword);
        Button buttonOk = dialog.findViewById(R.id.buttonOk);
        Button buttonCancel = dialog.findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel(); // hoặc .dismiss()
            }
        });
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                if (username.equals("abcd")
                        && password.equals("123")) {
                    Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnuGreen) {
            textViewTest.setBackgroundColor(Color.GREEN);
        }
        else if (item.getItemId() == R.id.mnuRed) {
            textViewTest.setBackgroundColor(Color.RED);
        } else {
            textViewTest.setBackgroundColor(Color.YELLOW);
        }
        return super.onOptionsItemSelected(item);
    }

    private void xacNhanXoa() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thong bao");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setMessage("Co xoa that khong?");
        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                monHoc.remove(val);
                adapter.notifyDataSetChanged();
                val = -1;
            }
        });
        alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }

    private void inits() {
        listView = findViewById(R.id.listView);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewTest = findViewById(R.id.textViewTest);
    }
}