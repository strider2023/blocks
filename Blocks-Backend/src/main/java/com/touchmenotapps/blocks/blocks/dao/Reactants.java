package com.touchmenotapps.blocks.blocks.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by i7 on 27-10-2017.
 */

public class Reactants {

    private List<Chemical> chemicals = new ArrayList<>();
    private List<Integer> balancedValues = new ArrayList<>();

    public Reactants() {

    }

    public void addDemoReactants() {
        Chemical hydrogen = new Chemical();
        hydrogen.createHydrogen();
        chemicals.add(hydrogen);
        balancedValues.add(2);
        Chemical oxygen = new Chemical();
        oxygen.createOxygen();
        chemicals.add(oxygen);
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
