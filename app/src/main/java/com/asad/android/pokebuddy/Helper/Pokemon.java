package com.asad.android.pokebuddy.Helper;

/**
 * Created by Asad on 9/18/2016.
 */
public class Pokemon
{


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int id;
    private String name;
    private String family;

    public String getIcon() {


String newIcon =         icon.substring(0, icon.lastIndexOf('.'));

        return newIcon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    private String icon;
    public double getMultipliers() {
        return multipliers;
    }

    public void setMultipliers(double multipliers) {
        this.multipliers = multipliers;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    private double multipliers;

    @Override
    public String toString() {
        return name;
    }


}
