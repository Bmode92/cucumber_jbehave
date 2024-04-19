package com.luxoft.javabdd.bank;

public class PremiumCreditOffer extends CreditOffer {

    private int amount = 300;
    public PremiumCreditOffer(String id) {
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
        return getCustomersSet().remove(customer);
    }
}
