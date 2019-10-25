package com.kata.vending.service;

import com.kata.vending.domain.COIN;

import java.util.HashMap;

public class VendingService {
    public double getChangeAmount(double cost, double payment) {
        return cost - payment;
    }

    public HashMap<COIN, Double> getCoins(double changeAmount) {
        HashMap<COIN, Double> changeInCoins = new HashMap<>();
        return changeInCoins;
    }
}
