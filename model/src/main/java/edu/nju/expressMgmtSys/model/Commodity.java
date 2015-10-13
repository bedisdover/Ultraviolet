package edu.nju.expressMgmtSys.model;

import java.io.Serializable;

public class Commodity implements Serializable{
    private static final long serialVersionUID = -901836914189125583L;

    private int nums;
    private int weight;
    private int volume;
    private String name;

    public Commodity(int nums, int weight, int volume, String name) {
        this.nums = nums;
        this.weight = weight;
        this.volume = volume;
        this.name = name;
    }

    public int getNums() {
        return nums;
    }

    public int getWeight() {
        return weight;
    }

    public int getVolume() {
        return volume;
    }

    public String getName() {
        return name;
    }
}
