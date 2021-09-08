package com.pduda.field;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingCartTest {


    @Test
    public void singleItem_numberOfProductsInTheCart() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(10);

        assertEquals(1, shoppingCart.numberOfProducts());
    }

    @Test
    public void singleItem_totalPrice() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(10);

        assertEquals(10, shoppingCart.calculateTotalPrice());
    }

    @Test
    public void singleItem_hasDiscountIfContainsAtLeastOneProductWorthAtLeast100() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(100);

        assertTrue(shoppingCart.hasDiscount());
    }

    @Test
    public void singleItem_doesNotHaveDiscountIfContainsNoProductsWorthAtLeast100() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(99);

        assertFalse(shoppingCart.hasDiscount());
    }

    @Test
    public void twoItems_numberOfProductsInTheCart() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(10, 20);

        assertEquals(2, shoppingCart.numberOfProducts());
    }

    @Test
    public void twoItems_totalPrice() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(10, 20);

        assertEquals(30, shoppingCart.calculateTotalPrice());
    }

}
