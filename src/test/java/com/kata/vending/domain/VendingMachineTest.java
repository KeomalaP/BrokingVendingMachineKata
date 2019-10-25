package com.kata.vending.domain;

import com.kata.vending.domain.VendingMachine;
import com.kata.vending.service.VendingService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VendingMachineTest {

    private VendingMachine vendingMachine = new VendingMachine();
    private VendingService vendingService = mock(VendingService.class);
    private HashMap<COIN, Double> testCoins = new HashMap<>();

    @BeforeAll
    public void setUp() {
        vendingMachine.setVendingService(vendingService);
        testCoins.put(COIN.QUARTER, 10.0);
        testCoins.put(COIN.TOTAL, 2.5);
    }

    @Test
    public void testGetChange_givenCostAndPayment_shouldReturnChangeAmount() {
        when(vendingService.getChangeAmount(5,2.5)).thenReturn(2.5);
        when(vendingService.getCoins(2.5)).thenReturn(testCoins);

        HashMap<COIN, Double> changeInCoins = vendingMachine.getChange(5, 2.5);

        assertEquals(2.5, changeInCoins.get(COIN.TOTAL));
        verify(vendingService, times(1)).getChangeAmount(5, 2.5);
        verify(vendingService, times(1)).getCoins(2.5);

    }

    @Test
    public void testGetChange_givenCostAndPayment_shouldReturnCoinsNeeded() {
        when(vendingService.getChangeAmount(5,2.5)).thenReturn(2.5);
        when(vendingService.getCoins(2.5)).thenReturn(testCoins);

        HashMap<COIN, Double> changeInCoins = vendingMachine.getChange(5,2.5);

        verify(vendingService, times(1)).getChangeAmount(5, 2.5);
        verify(vendingService, times(1)).getCoins(2.5);
        assertEquals(10, changeInCoins.get(COIN.QUARTER));
    }
}