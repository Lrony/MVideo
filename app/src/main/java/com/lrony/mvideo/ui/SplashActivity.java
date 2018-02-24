package com.lrony.mvideo.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lrony.mvideo.MainActivity;
import com.lrony.mvideo.R;

import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "SplashActivity";

    private static final int TIME_OUT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new TimerTask() {
            @Override
            public void run() {
                SplashActivity.this.startActivityForResult(new Intent(SplashActivity.this
                        , MainActivity.class), 0);
            }
        }, TIME_OUT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        finish();
    }
}
