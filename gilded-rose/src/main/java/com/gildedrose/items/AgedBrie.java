package com.gildedrose.items;

public class AgedBrie extends AbstractItem {

    public static final String NAME = "Aged Brie";

    public AgedBrie(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (this.sellIn < 0) {
            increaseItemQuality();
            increaseItemQuality();
        } else {
            increaseItemQuality();
        }
    }

    @Override
    public void updateSellIn() {
        decreaseSellIn();
    }
}
