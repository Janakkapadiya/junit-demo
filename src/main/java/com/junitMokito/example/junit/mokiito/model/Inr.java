package com.junitMokito.example.junit.mokiito.model;

public class Inr extends Money{
    public Inr(int amount) {
        super(amount);
    }

    @Override
    public String currency() {
        return "INR";
    }
}
