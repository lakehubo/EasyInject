package com.lake.singletondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SingleTonTester_Single.getInstance().showTime();
        for (int i = 0; i < 100; i++)
            new Thread(() -> {
                SingleTonTester_Single.getInstance().showTime();
            }).start();
    }
}