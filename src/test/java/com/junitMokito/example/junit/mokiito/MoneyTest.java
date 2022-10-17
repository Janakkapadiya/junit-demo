package com.junitMokito.example.junit.mokiito;

import com.junitMokito.example.junit.mokiito.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MoneyTest {

    @Test
    void testMultiplicationForDollar() {
        Money dollar = Money.dollar(10);
        dollar.multiplication(5);
        Assertions.assertEquals(Money.dollar(50), dollar);
    }

    @Test
    void testMultiplicationForInr() {
        Money inr = Money.inr(50);
        inr.multiplication(10);
        Assertions.assertEquals(Money.inr(500), inr);
    }

    @Test
    void TestEquality() {
        Assertions.assertEquals(Money.dollar(5), Money.dollar(5));
        assertNotEquals(Money.dollar(5), Money.dollar(4));
        assertNotEquals(Money.dollar(5), Money.inr(5));
    }

    @Test
    void TestCurrencies() {
        Assertions.assertEquals("USD", Money.dollar(500).currency());
        Assertions.assertEquals("INR", Money.inr(500).currency());
    }

    @Test
    void TestReturnSum() {
        Money sum = Money.inr(50);
        Expression expression = sum.addition(sum);
        Sum s = (Sum) expression;
        Assertions.assertEquals(sum,s.first());
        Assertions.assertEquals(sum,s.second());
    }

    @Test
    void TestAddition() {
        Expression amounts = new Sum(Money.inr(50), Money.inr(50));
        Bank bank = new Bank();
        Money amount = bank.finalAmount(amounts, "INR");
        Assertions.assertEquals(Money.inr(100), amount);
    }

    @Test
    void TestCheckAddition() {
        Money amount = Money.inr(50);
        Expression addition = amount.addition(amount);
        Bank bank = new Bank();
        Money amount1 = bank.finalAmount(addition, "INR");
        Assertions.assertEquals(Money.inr(100), amount1);
    }

    @Test
    void Test()
    {
      Bank bank = new Bank();
      bank.addRate("INR","USD",100);
      Money result = bank.finalAmount(Money.inr(100),"USD");
      Assertions.assertEquals(Money.dollar(1), result);
    }
}
