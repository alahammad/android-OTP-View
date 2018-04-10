package com.alahammad.otp_view.smsCatcher;

/**
 * Created by alahammad on 4/10/18.
 */

public interface OnSmsCatchListener<T> {
    void onSmsCatch(String message);
}
