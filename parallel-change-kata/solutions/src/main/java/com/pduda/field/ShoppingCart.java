package com.pduda.field;

public class ShoppingCart {
    private int price;

    public void add(int price) {
        this.price = price;
    }

    public int calculateTotalPrice() {
        return price;
    }

    public boolean hasDiscount() {
        return price >= 100;
    }

    public int numberOfProducts() {
        return 1;
    }
}
