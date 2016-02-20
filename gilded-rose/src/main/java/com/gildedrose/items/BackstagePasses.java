package com.gildedrose.items;

public class BackstagePasses extends AbstractItem {

    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public BackstagePasses(int sellIn, int quality) {
        super(NAME, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (sellIn > TEN_DAYS) {
            increaseItemQualityBy(1);
        }

        if (sellIn > FIVE_DAYS && sellIn <= TEN_DAYS) {
            increaseItemQualityBy(2);
        }

        if (sellIn <= FIVE_DAYS) {
            increaseItemQualityBy(3);
        }

        if (sellIn < 0) {
            setQualityToZero();
        }
    }

    @Override
    public void updateSellIn() {
        decreaseSellIn();
    }
}
