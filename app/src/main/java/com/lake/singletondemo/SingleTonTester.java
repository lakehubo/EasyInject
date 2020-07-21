package com.lake.singletondemo;

import android.util.Log;
import com.lake.easyinject.Singleton;
import com.lake.easyinject.SingletonType;

@Singleton(SingletonType.DLC)
public class SingleTonTester {

    public String test;

    public SingleTonTester() {
        test = System.currentTimeMillis() + "";
    }

    public void showTime() {
        Log.e("lake", Thread.currentThread().getName() + ":showTime: " + test);
    }
}
