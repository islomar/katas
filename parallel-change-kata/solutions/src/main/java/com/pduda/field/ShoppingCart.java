package com.pduda.field;

import java.util.Arrays;

public class ShoppingCart {
    private static final int MINIMUM_PRICE_FOR_DISCOUNT = 100;
    private int[] prices = null;

    public void add(int... prices) {
        this.prices = prices;
    }

    public int calculateTotalPrice() {
        return Arrays.stream(this.prices).sum();
    }

    public boolean hasDiscount() {
        return Arrays.stream(this.prices)
                .filter(item -> item >= MINIMUM_PRICE_FOR_DISCOUNT)
                .findAny()
                .isPresent();
    }

    public int numberOfProducts() {
        return this.prices.length;
    }
}
