package com.gildedrose;

public class GildedRose {

    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final int MAX_QUALITY = 50;
    private static final int NUMBER_OF_DAYS_EARLIER_WITH_DOUBLE_PRIZE = 10;
    private static final int NUMBER_OF_DAYS_EARLIER_WITH_TRIPLE_PRIZE = 5;
    private static final int MIN_QUALITY = 0;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

            if (!item.getName().equals(AGED_BRIE)
                && !item.getName().equals(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT)) {

                if (!item.getName().equals(SULFURAS_HAND_OF_RAGNAROS)) {
                    decreaseItemQualityIfApplies(item);
                }
            } else {
                if (item.getQuality() < MAX_QUALITY) {
                    item.increaseQuality();

                    if (item.getName().equals(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT)) {
                        if (item.getSellIn() <= NUMBER_OF_DAYS_EARLIER_WITH_DOUBLE_PRIZE) {
                            increaseItemQualityIfApplies(item);
                        }

                        if (item.getSellIn() <= NUMBER_OF_DAYS_EARLIER_WITH_TRIPLE_PRIZE) {
                            increaseItemQualityIfApplies(item);
                        }
                    }
                }
            }

            if (!item.getName().equals(SULFURAS_HAND_OF_RAGNAROS)) {
                item.decreaseSellIn();
            }

            if (item.getSellIn() < 0) {
                if (!item.getName().equals(AGED_BRIE)) {
                    if (!item.getName().equals(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT)) {
                        if (!item.getName().equals(SULFURAS_HAND_OF_RAGNAROS)) {
                            decreaseItemQualityIfApplies(item);
                        }
                    } else {
                        item.setQualityToZero();
                    }
                } else {
                    increaseItemQualityIfApplies(item);
                }
            }
        }
    }

    public void increaseItemQualityIfApplies(Item item) {
        if (item.getQuality() < MAX_QUALITY) {
            item.increaseQuality();
        }
    }

    public void decreaseItemQualityIfApplies(Item item) {
        if (item.getQuality() > MIN_QUALITY) {
            item.decreaseQuality();
        }
    }
}
