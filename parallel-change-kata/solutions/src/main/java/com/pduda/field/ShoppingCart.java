package com.pduda.field;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Integer> prices = new ArrayList<>();
    private int price;

    public void add(int price) {
        this.prices.add(price);
        this.price = price;
    }

    public int calculateTotalPrice() {
        return price;
    }

    public boolean hasDiscount() {
        return this.calculateTotalPrice() >= 100;
    }

    public int numberOfProducts() {
        return this.prices.size();
    }
}
