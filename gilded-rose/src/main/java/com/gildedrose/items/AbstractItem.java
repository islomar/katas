package com.gildedrose.items;

import com.gildedrose.Item;

public abstract class AbstractItem extends Item {

    protected static final int MAX_QUALITY = 50;
    protected static final int TEN_DAYS = 10;
    protected static final int FIVE_DAYS = 5;
    protected static final int MIN_QUALITY = 0;

    public AbstractItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public AbstractItem(Item item) {
        super(item.name, item.sellIn, item.quality);
    }

    public abstract void updateQuality();

    public abstract void updateSellIn();

    public void increaseItemQuality() {
        if (this.quality < MAX_QUALITY) {
            this.quality += 1;
        }
    }

    protected void decreaseItemQuality() {
        if (this.quality > MIN_QUALITY) {
            this.quality -= 1;
        }
    }

    protected void setQualityToZero() {
        this.quality = 0;
    }

    protected void decreaseSellIn() {
        this.sellIn -= 1;
    }
}
