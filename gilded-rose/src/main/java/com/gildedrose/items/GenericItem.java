package com.gildedrose.items;

public class GenericItem extends AbstractItem {


    public GenericItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
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
