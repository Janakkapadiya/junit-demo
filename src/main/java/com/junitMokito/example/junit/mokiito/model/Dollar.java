package com.junitMokito.example.junit.mokiito.model;

public class Dollar extends Money {
    public Dollar(int amount) {
        super(amount);
    }

    @Override
    public String currency() {
        return "USD";
    }
}
