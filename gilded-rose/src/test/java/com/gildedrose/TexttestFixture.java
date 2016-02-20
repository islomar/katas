package com.gildedrose;

import com.gildedrose.items.AbstractItem;
import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackstagePasses;
import com.gildedrose.items.DexterityVest;
import com.gildedrose.items.GenericItem;
import com.gildedrose.items.SulfurasHandOfRagnaros;

public class TexttestFixture {

    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        AbstractItem[] items = new AbstractItem[]{
            new DexterityVest(10, 20), //
            new AgedBrie(2, 0), //
            new GenericItem("Elixir of the Mongoose", 5, 7), //
            new SulfurasHandOfRagnaros(0, 80), //
            new SulfurasHandOfRagnaros(-1, 80),
            new BackstagePasses(15, 20),
            new BackstagePasses(10, 49),
            new BackstagePasses(5, 49),
            // this conjured item does not work properly yet
            new GenericItem("Conjured Mana Cake", 3, 6)};

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
