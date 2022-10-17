package com.junitMokito.example.junit.mokiito.model;

public class Inr extends Money{
    public Inr(int amount, String currency) {
        super(amount,currency);
    }
    @Override
    public String currency() {
        return currency;
    }
}
