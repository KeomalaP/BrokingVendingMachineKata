package com.kata.vending;

import com.kata.vending.domain.VendingMachine;
import com.kata.vending.service.VendingService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MainTest {

    private VendingMachine vendingMachine = new VendingMachine();
    private VendingService vendingService = mock(VendingService.class);


    @BeforeAll
    public void setUp() {
        vendingMachine.setVendingService(vendingService);
    }

    @Test
    public void testFindChangeAmountNeeded_givenCostAndPayment_shouldReturnChangeAmount() {
        when(vendingService.getChangeAmount(5,2.5)).thenReturn(2.5);
        double changeAmount = vendingMachine.getChange(5, 2.5);
        assertEquals(2.5, changeAmount);
        verify(vendingService, times(1)).getChangeAmount(5, 2.5);
    }
}