package com.pduda.field;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private int price;
    private List<Integer> prices = new ArrayList<Integer>();

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
