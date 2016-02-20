package com.gildedrose.items;

public class SulfurasHandOfRagnaros extends AbstractItem {

    private static final String NAME = "Sulfuras, Hand of Ragnaros";

    public SulfurasHandOfRagnaros(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        increaseItemQualityBy(1);
        if (sellIn < 0) {
            setQualityToZero();
        }
    }

    @Override
    public void updateSellIn() {
        //Nothing happens
    }
}
