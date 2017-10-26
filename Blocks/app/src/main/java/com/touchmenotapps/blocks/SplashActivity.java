package com.touchmenotapps.blocks;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.touchmenotapps.blocks.onboarding.AppIntroActivity;

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

        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(splashImage);
        Glide.with(this)
                .load(R.raw.splash)
                .into(imageViewTarget);
    }

    @OnClick(R.id.splash_login_google_btn)
    public void onGoogleLogin() {
        startActivity(new Intent(SplashActivity.this, AppIntroActivity.class));
        finish();
    }

    @OnClick(R.id.splash_login_btn)
    public void onLogin() {
        startActivity(new Intent(SplashActivity.this, AppIntroActivity.class));
        finish();
    }

    @OnClick(R.id.splash_signup_btn)
    public void onSignUp() {
        startActivity(new Intent(SplashActivity.this, AppIntroActivity.class));
        finish();
    }
}
