package com.luxoft.javabdd.bank;

public class BusinessCreditOffer extends CreditOffer {

    private final int amount = 200;

    public BusinessCreditOffer(String id) {
        super(id);
    }

    @Override
    public boolean addCustomer(Customer customer) {
        if (customer.isVip() && !super.checkCustomerInList(customer)) {
            customer.addPoints(super.calculateBonusPoints(customer, amount));
            return getCustomersSet().add(customer);
        }
        return false;
    }

    @Override
    public boolean removeCustomer(Customer customer) {
        if (customer.isVip()) {
            return false;
        }
        return getCustomersSet().remove(customer);
    }
}
