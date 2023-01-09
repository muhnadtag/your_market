package com.your_market;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

// هي الصفحة التي تظهر اول مرة يتم فيها فتح التطبيق ثم تختفي بعد مدة زمنية محددة
public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // بعد التاخير لمدة 5 ثواني الانتقال الي الصفحة الرئيسية للتطبيق
        // قمنا بإسخدام ال Handler للقيام بذلك بحيث انشئنا Handler جديد
        // ومررنا له دالة فتح الصفحة الجديدة و الزمن المطلوب تاخيره
        new Handler(Looper.getMainLooper()).postDelayed(()->{
            // دالة فتح الصفحة الجديدة
            startActivity(new Intent(this , categories.class));
            finish();
                }
                // الزمن المطلوب تاخيره وهو 5 ثوان
                , 5000 );
    }
}