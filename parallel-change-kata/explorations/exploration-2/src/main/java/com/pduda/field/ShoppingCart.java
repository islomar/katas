package com.pduda.field;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Integer> prices = new ArrayList<>();

    public void add(int price) {
        this.prices.add(price);
    }

    public int calculateTotalPrice() {
        return this.prices.stream().reduce(0, Integer::sum);
    }

    public boolean hasDiscount() {
        return this.prices.stream().anyMatch(price -> price >= 100);
    }

    public int numberOfProducts() {
        return this.prices.size();
    }
}
