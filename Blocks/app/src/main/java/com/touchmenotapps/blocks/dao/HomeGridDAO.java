package com.touchmenotapps.blocks.dao;

/**
 * Created by i7 on 27-10-2017.
 */

public class HomeGridDAO {

    private int image;
    private String name;

    public HomeGridDAO() {

    }

    public HomeGridDAO(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
