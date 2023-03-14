package com.example.intentresult2023;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextSoa, editTextSob;
    Button buttonSend;
    TextView textViewKq;
    private ActivityResultLauncher<Intent> mActivityResultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if (result.getResultCode() == 33) {
                                Intent intentTemp = result.getData();
                                int t = intentTemp.getIntExtra("tong", 1);
                                textViewKq.setText("Tong = " + t);
                            }
                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inItWidgets();
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLy();
            }
        });
    }

    private void xuLy() {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("a", Integer.parseInt(editTextSoa.getText().toString()));
        intent.putExtra("b", Integer.parseInt(editTextSob.getText().toString()));
        mActivityResultLauncher.launch(intent);
        // nhan ket qua tra ve
//        startActivityForResult(intent, 99);

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 99 && resultCode == 33) {
//            int t = data.getIntExtra("tong", 1);
//            textViewKq.setText("Tong = " + t);
//        }
//    }

    private void inItWidgets() {
        editTextSoa = findViewById(R.id.editTextSoa);
        editTextSob = findViewById(R.id.editTextSob);
        buttonSend = findViewById(R.id.buttonSend);
        textViewKq = findViewById(R.id.textViewKq);
    }
}