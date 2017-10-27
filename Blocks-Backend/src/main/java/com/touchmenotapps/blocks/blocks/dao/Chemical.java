package com.touchmenotapps.blocks.blocks.dao;

/**
 * Created by i7 on 27-10-2017.
 */

public class Chemical {

    private Long id;
    private String chemicalName;
    private String commonName;
    private String imageURL;
    private String videoURL;

    public Chemical() {

    }

    public void createHydrogen() {
        id = 1l;
        chemicalName = "H";
        commonName = "Hydrogen";
        imageURL = "";
        videoURL = "";
    }

    public void createWater() {
        id = 1l;
        chemicalName = "H2O";
        commonName = "Water";
        imageURL = "";
        videoURL = "";
    }

    public void createOxygen() {
        id = 1l;
        chemicalName = "O";
        commonName = "Oxygen";
        imageURL = "";
        videoURL = "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChemicalName() {
        return chemicalName;
    }

    public void setChemicalName(String chemicalName) {
        this.chemicalName = chemicalName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }
}
