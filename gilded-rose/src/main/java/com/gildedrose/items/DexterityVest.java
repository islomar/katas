package com.gildedrose.items;

public class DexterityVest extends AbstractItem {

    public static final String NAME = "+5 Dexterity Vest";

    public DexterityVest(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        decreaseItemQuality();
        if (sellIn < 0) {
            decreaseItemQuality();
        }
    }

    @Override
    public void updateSellIn() {
        decreaseSellIn();
    }
}
