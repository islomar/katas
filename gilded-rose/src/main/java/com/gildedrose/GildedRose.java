package com.gildedrose;

import com.gildedrose.items.AbstractItem;
import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.DexterityVest;

public class GildedRose {

    AbstractItem[] items;

    public GildedRose(AbstractItem[] abstractItems) {
        this.items = abstractItems;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            AbstractItem item = items[i];

            item.updateQuality();
            item.updateSellIn();
        }
    }
}
