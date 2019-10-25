package com.kata.vending.service;

public class VendingService {
    public double getChangeAmount(double cost, double payment) {
        return cost - payment;
    }
}
