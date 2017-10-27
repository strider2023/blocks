package com.touchmenotapps.blocks;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.touchmenotapps.blocks.farmework.AppPreferences;
import com.touchmenotapps.blocks.onboarding.AppIntroActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity {

    @BindView(R.id.splash_app_name)
    AppCompatTextView splashText;
    @BindView(R.id.splash_app_icon)
    ImageView splashIcon;
    @BindView(R.id.signup_name)
    AppCompatEditText nameEditText;
    @BindView(R.id.signup_email)
    AppCompatEditText emailEditText;
    @BindView(R.id.signup_phone_number)
    AppCompatEditText phoneEditText;
    @BindView(R.id.signup_password)
    AppCompatEditText passwordEditText;
    @BindView(R.id.signup_re_enter_password)
    AppCompatEditText rePasswordEditText;

    private String name, email, phoneNumber, password;
    private AppPreferences appPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        appPreferences = new AppPreferences(this);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(splashIcon);
                Glide.with(SignUpActivity.this)
                        .load(R.raw.splash)
                        .into(imageViewTarget);
            }
        }, 500);
    }

    @OnClick(R.id.signup_btn)
    public void OnSigupComplete() {
        name = nameEditText.getEditableText().toString().trim();
        email = emailEditText.getEditableText().toString().trim();
        phoneNumber = phoneEditText.getEditableText().toString().trim();
        password = passwordEditText.getEditableText().toString().trim();

        //TODO validate all fields
        if(name.length() > 0) {
            appPreferences.setLoggedIn();
            appPreferences.setChildName(name);
            startActivity(new Intent(this, SelectAvatarActivity.class));
            finish();
        } else {
            Snackbar.make(nameEditText, "Please provide the requested details.", Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {
        goPrevious();
    }

    private void goPrevious() {
        Intent intent = new Intent(this, SplashActivity.class);
        Pair<View, String> p1 = Pair.create((View) splashIcon, "splash");
        Pair<View, String> p2 = Pair.create((View) splashText, "splash");
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, p1, p2);
        startActivity(intent, options.toBundle());
        finish();
    }
}
