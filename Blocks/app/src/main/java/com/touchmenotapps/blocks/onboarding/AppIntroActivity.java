package com.touchmenotapps.blocks.onboarding;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;

import com.touchmenotapps.blocks.MainActivity;
import com.touchmenotapps.blocks.R;
import com.touchmenotapps.blocks.onboarding.listeners.IntroOnboardingOnRightOutListener;

import java.util.ArrayList;

public class AppIntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_intro);

        IntroOnboardingPage scr1 = new IntroOnboardingPage("Magical!",
                "Create and experience the world around you like never before. All you need it a phone and our cardboard kit.",
                Color.parseColor("#4e43f9"), R.drawable.ic_intro_magical, R.drawable.ic_point);
        IntroOnboardingPage scr2 = new IntroOnboardingPage("Dream Big",
                "With Blocks your imagination is the only barrier you face. Dream big and fascinate us and the community with your imagination.",
                Color.parseColor("#7c98fd"), R.drawable.ic_intro_imagine, R.drawable.ic_point);
        IntroOnboardingPage scr3 = new IntroOnboardingPage("Learn & Play",
                "Blocks inspires kids to learn through informal learning.",
                Color.parseColor("#4e43f9"), R.drawable.ic_intro_study, R.drawable.ic_point);

        ArrayList<IntroOnboardingPage> elements = new ArrayList<>();
        elements.add(scr1);
        elements.add(scr2);
        elements.add(scr3);

        IntroOnboardingFragment onBoardingFragment = IntroOnboardingFragment.newInstance(elements);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.intro_fragment_container, onBoardingFragment);
        fragmentTransaction.commit();

        onBoardingFragment.setOnRightOutListener(new IntroOnboardingOnRightOutListener() {
            @Override
            public void onRightOut() {
                Intent loginIntent = new Intent(AppIntroActivity.this, MainActivity.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Explode explode = new Explode();
                    explode.setDuration(500);
                    getWindow().setExitTransition(explode);
                    getWindow().setEnterTransition(explode);
                    ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(AppIntroActivity.this);
                    startActivity(loginIntent, oc2.toBundle());
                } else {
                    startActivity(loginIntent);
                }
                finish();
            }
        });
    }
}
