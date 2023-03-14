package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    TextView textViewTimer;
    CountDownTimer countDownTimer;
    int pairCnt = 0, curPos = -1;
    static int[] pos = new int[16];

    HinhAnh backGround;
    Button buttonNavigate;
    ArrayList<HinhAnh> arrayListHinhAnh;
    HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    final HinhAnh[] listHinhAnh = { new HinhAnh("Anh vuong", R.drawable.aa),
            new HinhAnh("Anh tron", R.drawable.bb),
            new HinhAnh("Anh sao", R.drawable.cc),
            new HinhAnh("Anh ngu giac", R.drawable.dd),
            new HinhAnh("Anh mui ten", R.drawable.ee) };

    public static void shuffleArray(int[] arr) {
        Random rnd = new Random();
        for (int i = 0; i < pos.length - 1; i += 2) {
            int num = rnd.nextInt(5);
            pos[i] = num;
            pos[i + 1] = num;
        }
        System.out.println(Arrays.toString(arr));

        for (int i = arr.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //khởi tạo
        HinhAnh backGround = new HinhAnh("Back Ground", R.drawable.bg);
        textViewTimer = findViewById(R.id.textViewTimer);
        buttonNavigate = findViewById(R.id.buttonNavigate);
        arrayListHinhAnh = new ArrayList<>();
        for (int i = 0; i < pos.length; ++i) {
            arrayListHinhAnh.add(backGround);
        }
        gridView = findViewById(R.id.gridView);
        HinhAnhAdapter adapter = new HinhAnhAdapter(MainActivity.this, R.layout.itemhinhanh, arrayListHinhAnh);
        gridView.setAdapter(adapter);


        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long l) {
                textViewTimer.setText("Timer: " + l / 1000 + "s");
            }

            @Override
            public void onFinish() {
                if (pairCnt * 2 != pos.length) {
                    Toast.makeText(MainActivity.this, "You Lose !!", Toast.LENGTH_LONG).show();
                }
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        return;
                    }
                });
            }
        };

        buttonNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.start();
                pairCnt = 0;
                curPos = -1;
                map.clear();
                shuffleArray(pos);
                arrayListHinhAnh.clear();
                for (int i = 0; i < pos.length; ++i) {
                    arrayListHinhAnh.add(backGround);
                }
                adapter.notifyDataSetChanged();
                // Bắt sự kiện click chuột
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        if (map.containsKey(i)) {
                            return;
                        }
                        if (curPos == -1) {
                            curPos = i;
                            arrayListHinhAnh.set(curPos, listHinhAnh[pos[i]]);
                            adapter.notifyDataSetChanged();
                            return;
                        }

                        if (curPos == i) {
                            arrayListHinhAnh.set(i, backGround);
                            curPos = -1;
                            adapter.notifyDataSetChanged();
                            return;
                        }

                        arrayListHinhAnh.set(i, listHinhAnh[pos[i]]);
                        adapter.notifyDataSetChanged();
                        if (pos[curPos] == pos[i]) {
                            pairCnt++;
                            map.put(curPos, true);
                            map.put(i, true);
                            curPos = -1;
                            if (pairCnt * 2 == pos.length) {
                                Toast.makeText(MainActivity.this, "You win", Toast.LENGTH_SHORT).show();
                                countDownTimer.cancel();
                            }
                            return;
                        }
                        Toast.makeText(MainActivity.this, "Not Match", Toast.LENGTH_SHORT).show();
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                arrayListHinhAnh.set(i, backGround);
                                arrayListHinhAnh.set(curPos, backGround);
                                adapter.notifyDataSetChanged();
                                curPos = -1;

                            }
                        }, 500);

                    }
                });
            }
        });
    }

}