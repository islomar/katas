package com.gildedrose.items;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SulfurasHandOfRagnaros extends AbstractItem {

    public static final String NAME = "Sulfuras, Hand of Ragnaros";

    public SulfurasHandOfRagnaros(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        increaseItemQualityIfApplies();
        if (sellIn < 0) {
            setQualityToZero();
        }
    }

    @Override
    public void updateSellIn() {
        //Nothing happens
    }
}
