package com.touchmenotapps.blocks;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.splash_image)
    ImageView splashImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        new Handler().postDelayed(new Runnable() {
            public void run() {

            }
        }, 2000);
    }

    @OnClick(R.id.splash_login_google_btn)
    public void onLogin() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
    }
}
