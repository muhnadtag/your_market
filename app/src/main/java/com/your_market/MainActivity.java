package com.your_market;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

// الصفحة الرئيسية لتطبيق سوقكم
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToRegister(View view) {

        // الذهاب الي صفحة انشاء الحساب
        startActivity(new Intent( this , register.class ));
    }

    public void go_to_categories(View view) {
        // الذهاب الي صفحة  فئات التسووق
        startActivity(new Intent( this , categories.class ));
    }
}