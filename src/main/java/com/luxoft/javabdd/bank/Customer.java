package com.luxoft.javabdd.bank;

public class Customer {

    private String name;
    private boolean vip;

    private int bonusPoints = 0;

    public Customer(String name, boolean vip) {
        this.name = name;
        this.vip = vip;
    }

    public String getName() {
        return name;
    }

    public boolean isVip() {
        return vip;
    }

    public void addPoints(int point) {
        bonusPoints += point;
    }

    public int getBonusPoints() {
        return bonusPoints;
    }

}
