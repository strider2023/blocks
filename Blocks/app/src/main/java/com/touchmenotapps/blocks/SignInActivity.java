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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInActivity extends AppCompatActivity {

    @BindView(R.id.splash_app_name)
    AppCompatTextView splashText;
    @BindView(R.id.splash_app_icon)
    ImageView splashIcon;
    @BindView(R.id.login_email)
    AppCompatEditText email;
    @BindView(R.id.login_password)
    AppCompatEditText password;

    private Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private AppPreferences appPreferences;
    private String userEmail, userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);

        appPreferences = new AppPreferences(this);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(splashIcon);
                Glide.with(SignInActivity.this)
                        .load(R.raw.splash)
                        .into(imageViewTarget);
            }
        }, 500);
    }

    @OnClick(R.id.login_btn)
    public void onUserLogin() {
        userEmail = email.getEditableText().toString().trim();
        userPassword = password.getEditableText().toString().trim();
        if(userEmail.length() > 0 && userPassword.length() > 0) {
            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email.getEditableText().toString().trim());
            if(matcher.find()) {
                appPreferences.setLoggedIn();
                if(userEmail.equalsIgnoreCase("child@next.in")) {
                    appPreferences.loggedInAsKid(true);
                } else {
                    appPreferences.loggedInAsKid(false);
                }
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }
        } else {
            Snackbar.make(splashText, "User email or password cannot be empty.", Snackbar.LENGTH_LONG).show();
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
