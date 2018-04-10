package com.alahammad.sample;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alahammad.otp_view.OTPListener;
import com.alahammad.otp_view.OtpView;
import com.alahammad.otp_view.smsCatcher.OnSmsCatchListener;
import com.alahammad.otp_view.smsCatcher.SmsVerifyCatcher;

public class MainActivity extends AppCompatActivity implements OTPListener, OnSmsCatchListener<String> {
    OtpView otpView;
    SmsVerifyCatcher smsVerifyCatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        otpView = findViewById(R.id.otp);
        smsVerifyCatcher = new SmsVerifyCatcher(this, this);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otpView.getOTP();
            }
        });

    }

    @Override
    public void otpFinished(String otp) {
        Log.d("otpSample", otp);
    }

    @Override
    public void onStart() {
        super.onStart();
        smsVerifyCatcher.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        smsVerifyCatcher.onStop();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        smsVerifyCatcher.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    @Override
    public void onSmsCatch(String message) {
        Log.d("otpSample", message);
    }
}
