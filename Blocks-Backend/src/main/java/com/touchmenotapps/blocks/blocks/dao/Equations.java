package com.touchmenotapps.blocks.blocks.dao;

import java.util.List;

/**
 * Created by i7 on 27-10-2017.
 */

public class Equations {

    public String equationName;
    public Reactants reactants;
    public Products products;
    public String videoURL;
    public String hint;

    public Equations() {

    }

    public void addDemoEquation() {
        equationName = "Water";
        reactants = new Reactants();
        reactants.addDemoReactants();
        products = new Products();
        products.addDemoProducts();
        videoURL = "";
        hint = "";
    }

    public String getEquationName() {
        return equationName;
    }

    public void setEquationName(String equationName) {
        this.equationName = equationName;
    }

    public Reactants getReactants() {
        return reactants;
    }

    public void setReactants(Reactants reactants) {
        this.reactants = reactants;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}
