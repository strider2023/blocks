package com.touchmenotapps.blocks.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.touchmenotapps.blocks.R;
import com.touchmenotapps.blocks.farmework.AppPreferences;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by i7 on 27-10-2017.
 */

public class ProfileFragment extends Fragment {

    @BindView(R.id.profile_avatar)
    ImageView kidAvatar;
    @BindView(R.id.profile_name)
    AppCompatTextView profileName;
    @BindView(R.id.profile_age)
    AppCompatTextView profileAge;

    private View mViewHolder;
    private AppPreferences appPreferences;

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewHolder = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, mViewHolder);

        appPreferences = new AppPreferences(getActivity());

        if(appPreferences.getChildAvatar()) {
            kidAvatar.setImageResource(R.drawable.ic_boy);
        } else {
            kidAvatar.setImageResource(R.drawable.ic_girl);
        }
        profileName.setText(appPreferences.getChildName());
        profileAge.setText(appPreferences.getChildAge());

        return mViewHolder;
    }
}
