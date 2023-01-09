package com.your_market;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

// هي الصفحة التي يتمكن من خلالها المسنخدم من تسجيل حساب في المنصة
public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void go_to_otp(View view) {
        // الذهاب الي صفحة التحقق
        startActivity( new Intent( this , otp.class ));
    }
}