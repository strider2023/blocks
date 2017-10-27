package com.touchmenotapps.blocks.blocks.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by i7 on 27-10-2017.
 */

public class Products {

    private List<Chemical> chemicals = new ArrayList<>();
    private List<Integer> balancedValues = new ArrayList<>();

    public Products() {

    }

    public void addDemoProducts() {
        Chemical water = new Chemical();
        water.createWater();
        chemicals.add(water);
        balancedValues.add(1);
    }

    public List<Chemical> getChemicals() {
        return chemicals;
    }

    public void setChemicals(List<Chemical> chemicals) {
        this.chemicals = chemicals;
    }

    public List<Integer> getBalancedValues() {
        return balancedValues;
    }

    public void setBalancedValues(List<Integer> balancedValues) {
        this.balancedValues = balancedValues;
    }
}
