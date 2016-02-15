package com.gildedrose;

public class GildedRose {

    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final int MAX_QUALITY = 50;
    private static final int NUMBER_OF_DAYS_EARLIER_WITH_DOUBLE_PRIZE = 10;
    private static final int NUMBER_OF_DAYS_EARLIER_WITH_TRIPLE_PRIZE = 5;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (!item.name.equals(AGED_BRIE)
                && !item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT)) {
                if (item.quality > 0) {
                    if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < MAX_QUALITY) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT)) {
                        if (item.sellIn <= NUMBER_OF_DAYS_EARLIER_WITH_DOUBLE_PRIZE) {
                            if (item.quality < MAX_QUALITY) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn <= NUMBER_OF_DAYS_EARLIER_WITH_TRIPLE_PRIZE) {
                            if (item.quality < MAX_QUALITY) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(AGED_BRIE)) {
                    if (!item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT)) {
                        if (item.quality > 0) {
                            if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (item.quality < MAX_QUALITY) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
