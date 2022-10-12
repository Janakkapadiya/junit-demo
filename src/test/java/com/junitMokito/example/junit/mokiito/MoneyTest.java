package com.junitMokito.example.junit.mokiito;

import com.junitMokito.example.junit.mokiito.model.Dollar;
import com.junitMokito.example.junit.mokiito.model.Inr;
import com.junitMokito.example.junit.mokiito.model.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MoneyTest {

    @Test
    void testMultiplicationForDollar(){
        Dollar dollar = Money.dollar(10);
        dollar.multiplication(5);
        Assertions.assertEquals(new Dollar(50),dollar);
    }

    @Test
    void testMultiplicationForInr()
    {
        Inr inr = Money.inr(50);
        inr.multiplication(10);
        Assertions.assertEquals(new Inr(500),inr);
    }

    @Test
    void TestEquality()
    {
        Assertions.assertEquals(new Dollar(5),(new Dollar(5)));
        assertNotEquals(new Dollar(5),new Dollar(4));
        assertNotEquals(new Dollar(5),new Inr(5));
    }

    @Test
    void TestCurrencies()
    {
        Assertions.assertEquals("USD",Money.dollar(500).currency());
        Assertions.assertEquals("INR",Money.inr(500).currency());
    }
}
