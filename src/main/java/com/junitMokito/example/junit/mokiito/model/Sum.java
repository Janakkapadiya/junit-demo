package com.junitMokito.example.junit.mokiito.model;

public record Sum(Money first, Money second) implements Expression {
    public Money finalAmount(String s) {
        int amount = first.amount + second.amount;
        return new Money(amount, s);
    }
}
