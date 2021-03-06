package com.touchmenotapps.blocks.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.touchmenotapps.blocks.R;
import com.touchmenotapps.blocks.adapters.HomeGridAdapter;
import com.touchmenotapps.blocks.dao.HomeGridDAO;
import com.touchmenotapps.blocks.farmework.AppPreferences;
import com.touchmenotapps.blocks.interfaces.HomeGridItemListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by i7 on 27-10-2017.
 */

public class HomeFragment extends Fragment implements HomeGridItemListener{

    @BindView(R.id.home_grid_view)
    RecyclerView homeGrid;
    @BindView(R.id.home_kids_avatar_base)
    LinearLayout kidsAvatarContainer;
    @BindView(R.id.home_avatar)
    ImageView kidAvatar;
    @BindView(R.id.home_interaction_text)
    AppCompatTextView avatarText;

    private View mViewHolder;
    private AppPreferences appPreferences;
    private List<HomeGridDAO> homeGridDAOs = new ArrayList<>();
    private HomeGridAdapter homeGridAdapter;
    private GridLayoutManager gridLayoutManager;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewHolder = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, mViewHolder);

        appPreferences = new AppPreferences(getActivity());
        homeGridAdapter = new HomeGridAdapter(this);
        gridLayoutManager = new GridLayoutManager(getActivity(), 3);

        if(appPreferences.isLoggedInAsKid()) {
            kidsAvatarContainer.setVisibility(View.VISIBLE);
            homeGridDAOs.add(new HomeGridDAO(1, R.drawable.ic_flower, "Objects"));
            homeGridDAOs.add(new HomeGridDAO(2, R.drawable.ic_cat, "Animals"));
            homeGridDAOs.add(new HomeGridDAO(3, R.drawable.ic_explore, "Navigation"));
            homeGridDAOs.add(new HomeGridDAO(4, R.drawable.ic_chemistry, "Chemistry"));
            homeGridDAOs.add(new HomeGridDAO(5, R.drawable.ic_worker, "Build Cities"));
        } else {
            homeGridDAOs.add(new HomeGridDAO(4, R.drawable.ic_chemistry, "Chemistry"));
            homeGridDAOs.add(new HomeGridDAO(5, R.drawable.ic_worker, "Build Cities"));
        }

        if(appPreferences.getChildAvatar()) {
            kidAvatar.setImageResource(R.drawable.ic_boy);
        } else {
            kidAvatar.setImageResource(R.drawable.ic_girl);
        }

        avatarText.setText("Hi, " + appPreferences.getChildName() + " what do you want to explore with BLOCKS today?");

        homeGrid.setLayoutManager(gridLayoutManager);
        homeGrid.setAdapter(homeGridAdapter);
        homeGridAdapter.setData(homeGridDAOs);

        return mViewHolder;
    }

    @Override
    public void OnHomeGridItemSelected(HomeGridDAO homeGridDAO) {
        try {
            Intent launchIntent;
            switch (homeGridDAO.getId()) {
                case 2:
                    launchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.touchmenotapps.blocks.animal");
                    startActivity(launchIntent);
                    break;
                case 3:
                    launchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.touchmenotapps.blocks.city");
                    startActivity(launchIntent);
                    break;
                case 4:
                    launchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.touchmenotapps.blocks.chemistry");
                    startActivity(launchIntent);
                    break;
                case 5:
                    launchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.touchmenotapps.blocks.city");
                    startActivity(launchIntent);
                    break;
            }
        } catch (Exception e) {

        }
    }
}
