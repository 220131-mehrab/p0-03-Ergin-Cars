package com.revature.cars;

public class BrandName {
    private String car;
    private int mpg;

    public BrandName(){

    }

    public BrandName(String car, int mpg) {
        this.car = car;
        this.mpg = mpg;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public int getMpg() {
        return mpg;
    }

    public void setMpg(int mpg) {
        this.mpg = mpg;
    }

    @Override
    public String toString() {
        return "BrandName{" +
                "car='" + car + '\'' +
                ", mpg=" + mpg +
                '}';
    }
}
