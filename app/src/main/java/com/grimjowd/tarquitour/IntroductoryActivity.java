package com.grimjowd.tarquitour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class IntroductoryActivity extends AppCompatActivity {

    ImageView logo,appName,splashImg;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);

        logo = findViewById(R.id.img);
        appName = findViewById(R.id.app_name);
        splashImg = findViewById(R.id.mensaje);
        lottieAnimationView = findViewById(R.id.lottie);


        logo.animate().translationY(-2200).setDuration(1000).setStartDelay(4000);
        appName.animate().translationY(2000).setDuration(1000).setStartDelay(4000);
        splashImg.animate().translationY(1800).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1800).setDuration(1000).setStartDelay(4000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(IntroductoryActivity.this, MainActivity2.class);
                startActivity(intent);


                finish();
            }
        }, 5500);
    }
}