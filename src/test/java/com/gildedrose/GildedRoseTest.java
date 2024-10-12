package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }


    @Test
    void quality_degrades_twice_as_fast_after_sell_by_date() {
        Item[] items = new Item[] { new Item("foo", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void quality_of_an_item_is_never_negative() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void aged_brie_increases_in_Quality_the_older_it_gets() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(31, app.items[0].quality);
    }


    @Test
    void quality_of_an_item_is_never_more_than_50() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 48) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(49, app.items[0].quality);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }


    @Test
    void sulfuras_never_decreases_in_quality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }


    @Test
    void backstage_passes_increases_in_Quality_as_its_SellIn_value_approaches() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        // quality increases by 1 as the sellin is 11 days
        assertEquals(6, app.items[0].quality);
        app.updateQuality();
        // quality increases by 2 as the sellin is 10 days
        assertEquals(8, app.items[0].quality);
        app.updateQuality();
        // quality increases by 2 as the sellin is 9 days
        assertEquals(10, app.items[0].quality);



        Item[] items2 = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6, 5) };
        GildedRose app2 = new GildedRose(items2);
        app2.updateQuality();
        // quality increases by 2 as the sellin is 6 days
        assertEquals(7, app2.items[0].quality);

        app2.updateQuality();
        // quality increases by 3 as the sellin is 5 days
        assertEquals(10, app2.items[0].quality);

        app2.updateQuality();
        // quality increases by 3 as the sellin is 4 days
        assertEquals(13, app2.items[0].quality);

    }


    @Test
    void backstage_passes_quality_drops_to_0_after_the_concert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }


}
