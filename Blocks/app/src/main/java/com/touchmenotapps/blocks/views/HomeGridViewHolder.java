package com.touchmenotapps.blocks.views;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.touchmenotapps.blocks.R;
import com.touchmenotapps.blocks.dao.HomeGridDAO;
import com.touchmenotapps.blocks.interfaces.HomeGridItemListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by i7 on 27-10-2017.
 */

public class HomeGridViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.home_grid_image)
    ImageView image;
    @BindView(R.id.home_grid_text)
    AppCompatTextView name;

    private HomeGridItemListener homeGridItemListener;
    private HomeGridDAO data;

    public HomeGridViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setHomeGridItemListener(HomeGridItemListener homeGridItemListener) {
        this.homeGridItemListener = homeGridItemListener;
    }

    public void setData(HomeGridDAO homeGridDAO) {
        data = homeGridDAO;
        image.setImageResource(data.getImage());
        name.setText(data.getName());
    }

    @OnClick(R.id.home_grid_base_container)
    public void OnGridItemClicked() {
        if(this.homeGridItemListener != null) {
            this.homeGridItemListener.OnHomeGridItemSelected(data);
        }
    }
}
