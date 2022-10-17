package com.junitMokito.example.junit.mokiito.model;

import java.util.Objects;
public class Money implements Expression {
    protected int amount;
    protected final String currency;

    protected Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money inr(int amount) {
        return new Money(amount, "INR");
    }

    public String currency() {
        return currency;
    }

    public void multiplication(int value) {
        this.amount *= value;
    }

    public Expression addition(Money added) {
        return new Sum(this, added);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money money)) return false;
        return amount == money.amount && Objects.equals(this.currency, money.currency);
    }
    @Override
    public Money finalAmount(String s) {
//        return this;
        int rate = (currency.equals("INR") && s.equals("USD")) ? 100 : 1;
        return new Money(amount/rate,s);
    }
}
