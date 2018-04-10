package com.alahammad.sample;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alahammad.otp_view.OTPListener;
import com.alahammad.otp_view.OtpView;
import com.alahammad.otp_view.smsCatcher.OnSmsCatchListener;
import com.alahammad.otp_view.smsCatcher.SmsVerifyCatcher;

public class MainActivity extends AppCompatActivity implements OTPListener, OnSmsCatchListener<String> {
    OtpView otpView;
    SmsVerifyCatcher smsVerifyCatcher;

    private TextView mOtpTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mOtpTextView = findViewById(R.id.tv_otp);
        otpView = findViewById(R.id.otp);
        otpView.setOnOtpFinished(this);
        smsVerifyCatcher = new SmsVerifyCatcher(this, this);
    }

    @Override
    public void otpFinished(String otp) {

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
        mOtpTextView.setText(message);
    }
}
