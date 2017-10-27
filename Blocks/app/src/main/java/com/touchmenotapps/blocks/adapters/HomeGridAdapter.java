package com.touchmenotapps.blocks.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touchmenotapps.blocks.R;
import com.touchmenotapps.blocks.dao.HomeGridDAO;
import com.touchmenotapps.blocks.interfaces.HomeGridItemListener;
import com.touchmenotapps.blocks.views.HomeGridViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by i7 on 27-10-2017.
 */

public class HomeGridAdapter extends RecyclerView.Adapter<HomeGridViewHolder> {

    private HomeGridItemListener homeGridItemListener;
    private List<HomeGridDAO> homeGridDAOs = new ArrayList<>();

    public HomeGridAdapter(HomeGridItemListener homeGridItemListener) {
        this.homeGridItemListener = homeGridItemListener;
    }

    public void setData(List<HomeGridDAO> homeGridDAOs) {
        this.homeGridDAOs = homeGridDAOs;
        notifyDataSetChanged();
    }

    @Override
    public HomeGridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_home_grid,
                parent, false);
        return new HomeGridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeGridViewHolder holder, int position) {
        holder.setHomeGridItemListener(homeGridItemListener);
        holder.setData(homeGridDAOs.get(position));
    }

    @Override
    public int getItemCount() {
        return homeGridDAOs.size();
    }
}
