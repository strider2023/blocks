package com.touchmenotapps.blocks;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.LinearLayout;

import com.touchmenotapps.blocks.farmework.AppPreferences;
import com.touchmenotapps.blocks.onboarding.AppIntroActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectAvatarActivity extends AppCompatActivity {

    @BindView(R.id.user_age_edittext)
    AppCompatEditText userAge;
    @BindView(R.id.select_age_container)
    LinearLayout ageContainer;
    @BindView(R.id.select_avatar_container)
    LinearLayout avatarContainer;

    private AppPreferences appPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_avatar);
        ButterKnife.bind(this);
        appPreferences = new AppPreferences(this);
    }

    @OnClick(R.id.submit_age_btn)
    public void onSubmitAge() {
        if(userAge.getEditableText().toString().trim().length() > 0) {
            appPreferences.setChildAge(userAge.getEditableText().toString().trim());
            ageContainer.setVisibility(View.GONE);
            avatarContainer.setVisibility(View.VISIBLE);
        } else {
            Snackbar.make(ageContainer, "Please provide a valid input!", Snackbar.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.boy_avatar_btn)
    public void onBoyAvatarClicked() {
        appPreferences.setChildAvatar(true);
        startActivity(new Intent(this, AppIntroActivity.class));
        finish();
    }

    @OnClick(R.id.girl_avatar_btn)
    public void onGirlAvatarClicked() {
        appPreferences.setChildAvatar(false);
        startActivity(new Intent(this, AppIntroActivity.class));
        finish();
    }
}
