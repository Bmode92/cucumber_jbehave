package com.luxoft.javabdd.bank;

import java.util.*;

public abstract class CreditOffer {

    private String id;
    private Set<Customer> customersSet = new HashSet<>();

    public CreditOffer(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Set<Customer> getCustomersSet() {
        return customersSet;
    }

    public abstract boolean addCustomer(Customer customer);

    public abstract boolean removeCustomer(Customer customer);

    public boolean checkCustomerInList(Customer customer) {
        return getCustomersSet().contains(customer);
    }

    public int calculateBonusPoints(Customer customer, int amount) {
        int points = 0;
        if (customer.isVip()) {
            points = amount / 10;
        } else {
            points = amount / 20;
        }
        return points;
    }

}
