package com.gildedrose;

import com.gildedrose.items.AbstractItem;
import com.gildedrose.items.AbstractItemFactory;
import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackstagePasses;
import com.gildedrose.items.DexterityVest;
import com.gildedrose.items.SulfurasHandOfRagnaros;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;

public class GildedRoseTest {


    @Test
    public void should_never_changes_quailty_of_Sulfuras() throws Exception {
        AbstractItem sulfuras = new SulfurasHandOfRagnaros(0, 80);

        GildedRose sut = new GildedRose((AbstractItem[]) Arrays.asList(sulfuras).toArray());

        sut.updateQuality();

        assertEquals(80, sulfuras.quality);
    }

    @Test
    public void should_never_changes_sellIn_of_Sulfuras() throws Exception {
        AbstractItem sulfuras = new SulfurasHandOfRagnaros(0, 80);

        GildedRose sut = new GildedRose((AbstractItem[]) Arrays.asList(sulfuras).toArray());

        sut.updateQuality();

        assertEquals(0, sulfuras.sellIn);
    }


    @Test
    public void should_lower_the_sellIn_by_one_for_normal_items() throws Exception {
        AbstractItem normalItem = new DexterityVest(10, 20);

        GildedRose sut = new GildedRose((AbstractItem[]) Arrays.asList(normalItem).toArray());

        sut.updateQuality();

        assertEquals(9, normalItem.sellIn);
    }

    @Test
    public void should_lower_the_quality_by_one_for_normal_items() throws Exception {
        AbstractItem normalItem = new DexterityVest(10, 20);

        GildedRose sut = new GildedRose((AbstractItem[]) Arrays.asList(normalItem).toArray());

        sut.updateQuality();

        assertEquals(19, normalItem.quality);
    }

    @Test
    public void should_not_lower_the_quality_below_zero() throws Exception {
        AbstractItem normalItem = new DexterityVest(10, 0);

        GildedRose sut = new GildedRose((AbstractItem[]) Arrays.asList(normalItem).toArray());

        sut.updateQuality();

        assertEquals(0, normalItem.quality);
    }

    @Test
    public void should_lower_the_quality_twice_as_fast_once_the_sell_in_date_has_passed() throws Exception {
        AbstractItem normalItem = new DexterityVest(-1, 25);

        GildedRose sut = new GildedRose((AbstractItem[]) Arrays.asList(normalItem).toArray());

        sut.updateQuality();

        assertEquals(23, normalItem.quality);
    }


    @Test
    public void should_increase_the_quality_of_aged_brie_as_it_gets_older() throws Exception {
        AbstractItem agedBrie = new AgedBrie(10, 25);

        GildedRose sut = new GildedRose((AbstractItem[]) Arrays.asList(agedBrie).toArray());

        sut.updateQuality();

        assertEquals(26, agedBrie.quality);
    }


    @Test
    public void should_not_increase_the_quality_of_aged_brie_over_50() throws Exception {
        AbstractItem agedBrie = new AgedBrie(10, 50);

        GildedRose sut = new GildedRose((AbstractItem[]) Arrays.asList(agedBrie).toArray());

        sut.updateQuality();

        assertEquals(50, agedBrie.quality);
    }

    @Test
    public void should_lower_backstage_passes_to_zero_quality_once_concert_has_happened() throws Exception {
        AbstractItem backStagePass = new BackstagePasses(-1, 20);

        GildedRose sut = new GildedRose((AbstractItem[]) Arrays.asList(backStagePass).toArray());

        sut.updateQuality();

        assertEquals(0, backStagePass.quality);
    }

    @Test
    public void should_increase_backstage_passes_quality_by_1_when_the_concert_is_more_than_10_days_away() throws Exception {
        AbstractItem backStagePass = new BackstagePasses(11, 20);

        GildedRose sut = new GildedRose((AbstractItem[]) Arrays.asList(backStagePass).toArray());

        sut.updateQuality();

        assertEquals(21, backStagePass.quality);
    }

    @Test
    public void should_increase_backstage_passes_quality_by_2_when_the_concert_is_10_days_or_less_away() throws Exception {
        AbstractItem backStagePass = new BackstagePasses(10, 27);

        GildedRose sut = new GildedRose((AbstractItem[]) Arrays.asList(backStagePass).toArray());

        sut.updateQuality();

        assertEquals(29, backStagePass.quality);
    }

    @Test
    public void should_increase_backstage_passes_quality_by_3_when_the_concert_is_5_days_or_less_away() throws Exception {
        AbstractItem backStagePass = new BackstagePasses(5, 44);

        GildedRose sut = new GildedRose((AbstractItem[]) Arrays.asList(backStagePass).toArray());

        sut.updateQuality();

        assertEquals(47, backStagePass.quality);
    }

    @Test
    public void should_not_increase_backstage_passes_above_a_quality_of_50() throws Exception {
        AbstractItem backStagePassMoreThan10DaysAway = new BackstagePasses(15, 50);

        AbstractItem backStagePass10DaysAway = new BackstagePasses(5, 49);
        AbstractItem backStagePass5DaysAway = new BackstagePasses(5, 48);

        GildedRose
            sut =
            new GildedRose(
                (AbstractItem[]) Arrays.asList(backStagePassMoreThan10DaysAway, backStagePass10DaysAway, backStagePass5DaysAway).toArray());

        sut.updateQuality();

        assertEquals(50, backStagePassMoreThan10DaysAway.quality);
        assertEquals(50, backStagePass10DaysAway.quality);
        assertEquals(50, backStagePass5DaysAway.quality);
    }

}
