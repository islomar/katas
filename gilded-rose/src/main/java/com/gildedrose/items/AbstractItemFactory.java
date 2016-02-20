package com.gildedrose.items;


import java.util.NoSuchElementException;

public class AbstractItemFactory {

    public static AbstractItem createItem(String name, int sellIn, int quality) {
        if (AgedBrie.NAME.equalsIgnoreCase(name)) {
            return new AgedBrie(sellIn, quality);
        } else if (BackstagePasses.NAME.equalsIgnoreCase(name)) {
            return new BackstagePasses(sellIn, quality);
        } else if (SulfurasHandOfRagnaros.NAME.equalsIgnoreCase(name)) {
            return new SulfurasHandOfRagnaros(sellIn, quality);
        } else {
            throw new NoSuchElementException("There is no item registered with this name");
        }
    }

}
