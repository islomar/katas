package com.pduda.field;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingCartTest {


    @Test
    public void singleItem_numberOfProductsInTheCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(10);

        assertEquals(1, shoppingCart.numberOfProducts());
    }

    @Test
    public void singleItem_totalPrice() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(10);

        assertEquals(10, shoppingCart.calculateTotalPrice());
    }

    @Test
    public void singleItem_hasDiscountIfContainsAtLeastOneProductWorthAtLeast100() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(100);

        assertTrue(shoppingCart.hasDiscount());
    }

    @Test
    public void singleItem_doesNotHaveDiscountIfContainsNoProductsWorthAtLeast100() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(99);

        assertFalse(shoppingCart.hasDiscount());
    }

    @Test
    public void twoItems_numberOfProductsInTheCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(10, 20);

        assertEquals(2, shoppingCart.numberOfProducts());
    }

    @Test
    public void twoItems_totalPrice() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(10, 20);

        assertEquals(30, shoppingCart.calculateTotalPrice());
    }

    //TODO: this requirement is not clear: should the discount be applied when
    //the total amount is at least 100? Should it be applied when
    // at least one product is 100 (as mentioned in the test)?
    @Test
    public void twoItems_hasDiscountIfContainsAtLeastOneProductWorthAtLeast100() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(40, 100);

        assertTrue(shoppingCart.hasDiscount());
    }

    @Test
    public void twoItems_hasNoDiscountIfNoProductIsWorthAtLeast100() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(40, 60);

        assertFalse(shoppingCart.hasDiscount());
    }

}
