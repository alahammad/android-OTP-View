package com.alahammad.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alahammad.otp_view.OtpView;

public class MainActivity extends AppCompatActivity {
    OtpView otpView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        otpView = findViewById(R.id.otp);
//        otpView.enableKeypad();
    }
}
