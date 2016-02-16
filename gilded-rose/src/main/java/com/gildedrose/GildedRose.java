package com.gildedrose;

public class GildedRose {

    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final int MAX_QUALITY = 50;
    private static final int TEN_DAYS = 10;
    private static final int FIVE_DAYS = 5;
    private static final int MIN_QUALITY = 0;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            String itemName = item.name;
            int itemQuality = item.quality;
            int itemSellIn = item.sellIn;

            if (!itemName.equals(AGED_BRIE)
                && !itemName.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT)
                && !itemName.equals(SULFURAS_HAND_OF_RAGNAROS)) {

                decreaseItemQualityIfApplies(item);
            }

            if (itemName.equals(AGED_BRIE)
                 || itemName.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT)
                 || itemName.equals(SULFURAS_HAND_OF_RAGNAROS)) {

                increaseItemQualityIfApplies(item);
            }

            if (itemName.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT)) {
                if (itemSellIn <= FIVE_DAYS) {
                    increaseItemQualityIfApplies(item);
                    increaseItemQualityIfApplies(item);
                }

                if (itemSellIn > FIVE_DAYS && itemSellIn <= TEN_DAYS) {
                    increaseItemQualityIfApplies(item);
                }
            }

            if (!itemName.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                item.sellIn -= 1;
            }

            if (itemSellIn < 0 && !itemName.equals(AGED_BRIE)) {
                if (!itemName.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT)
                    && !itemName.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                    decreaseItemQualityIfApplies(item);
                } else {
                    setQualityToZero(item);
                }
            }

            if (itemSellIn < 0 && itemName.equals(AGED_BRIE)) {
                increaseItemQualityIfApplies(item);
            }
        }
    }

    public void increaseItemQualityIfApplies(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality += 1;
        }
    }

    public void decreaseItemQualityIfApplies(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality -= 1;
        }
    }

    public void setQualityToZero(Item item) {
        item.quality = 0;
    }
}
