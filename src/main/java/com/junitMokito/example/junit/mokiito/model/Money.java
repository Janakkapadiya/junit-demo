package com.junitMokito.example.junit.mokiito.model;

import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public abstract class Money{
    private int amount;
    public void multiplication(int value)
    {
        this.amount *= value;
    }

    public static Dollar dollar(int amount)
    {
        return new Dollar(amount);
    }

    public static Inr inr(int amount)
    {
        return new Inr(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money money)) return false;
        return amount == money.amount && this.getClass().equals(o.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    public abstract String currency();
}
