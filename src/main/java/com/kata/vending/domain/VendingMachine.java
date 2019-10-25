package com.kata.vending.domain;

import com.kata.vending.service.VendingService;

public class VendingMachine {

    private VendingService vendingService = new VendingService();

    public double getChange(double cost, double payment) {
        return vendingService.getChangeAmount(cost, payment);
    }

    public void setVendingService(VendingService vendingService) {
        this.vendingService = vendingService;
    }
}
