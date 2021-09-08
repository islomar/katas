package com.pduda.field;

import java.util.Arrays;

public class ShoppingCart {
    private int[] prices = null;

    public void add(int... prices) {
        this.prices = prices;
    }

    public int calculateTotalPrice() {
        return Arrays.stream(this.prices).sum();
    }

    public boolean hasDiscount() {
        return Arrays.stream(this.prices)
                .filter(item -> item >= 100)
                .findAny()
                .isPresent();
    }

    public int numberOfProducts() {
        return this.prices.length;
    }
}
