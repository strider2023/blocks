package com.touchmenotapps.blocks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.touchmenotapps.blocks.farmework.AppPreferences;
import com.touchmenotapps.blocks.onboarding.AppIntroActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectAvatarActivity extends AppCompatActivity {

    private AppPreferences appPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_avatar);
        ButterKnife.bind(this);

        appPreferences = new AppPreferences(this);
    }

    @OnClick(R.id.boy_avatar_btn)
    public void onBoyAvatarClicked() {
        appPreferences.setChildAvatar(true);
        startActivity(new Intent(this, AppIntroActivity.class));
        finish();
    }

    @OnClick(R.id.boy_avatar_btn)
    public void onGirlAvatarClicked() {
        appPreferences.setChildAvatar(false);
        startActivity(new Intent(this, AppIntroActivity.class));
        finish();
    }
}
