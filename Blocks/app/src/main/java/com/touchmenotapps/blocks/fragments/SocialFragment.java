package com.touchmenotapps.blocks.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touchmenotapps.blocks.R;

import butterknife.ButterKnife;

/**
 * Created by i7 on 27-10-2017.
 */

public class SocialFragment extends Fragment {

    private View mViewHolder;

    public static SocialFragment newInstance() {
        SocialFragment fragment = new SocialFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewHolder = inflater.inflate(R.layout.fragment_social, container, false);
        ButterKnife.bind(this, mViewHolder);

        return mViewHolder;
    }
}
