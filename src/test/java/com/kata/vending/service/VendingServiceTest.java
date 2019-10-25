package com.kata.vending.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendingServiceTest {

    private VendingService vendingService = new VendingService();

    @Test
    public void testGetChangeAmount_givenCostAndPayment_shouldReturnChangeAmount() {
        double actual = vendingService.getChangeAmount(5, 2.5);
        assertEquals(2.5, actual);
    }
}