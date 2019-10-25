package com.kata.vending.domain;

import com.kata.vending.service.VendingService;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private VendingService vendingService = new VendingService();

    public HashMap<COIN, Double> getChange(double cost, double payment) {
        HashMap<COIN, Double> changeInCoins = new HashMap<>();
        double changeAmt = vendingService.getChangeAmount(cost, payment);
        changeInCoins = vendingService.getCoins(changeAmt);
        return changeInCoins;
    }

    public void setVendingService(VendingService vendingService) {
        this.vendingService = vendingService;
    }
}
