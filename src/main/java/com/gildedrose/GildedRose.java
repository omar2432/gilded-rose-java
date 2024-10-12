package com.gildedrose;

class GildedRose {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    static Item[] items;

    public GildedRose(Item[] items) {
        GildedRose.items = items;
    }

    public static void updateQuality() {
        // Retrieve length once
        int itemsLength = items.length;

        for (int i = 0; i < itemsLength; i++) {
            Item item = items[i];

            if (item.name.equals(SULFURAS)) {
                // we could remove this line if it doesnot change
                item.quality=80;
                continue;
            }

            updateSellIn(item);

            if (item.name.equals(AGED_BRIE)) {
                updateAgedBrie(item);
            } else if (item.name.equals(BACKSTAGE_PASSES)) {
                updateBackstagePasses(item);
            } else {
                updateRegularItem(item);
            }

            if (item.sellIn < 0) {
                handleExpiredItem(item);
            }
        }
    }

    private static void updateSellIn(Item item) {
        item.sellIn--;
    }

    private static void updateAgedBrie(Item item) {
        increaseQuality(item);
    }

    private static void updateBackstagePasses(Item item) {
        if (item.sellIn < 0) {
            item.quality = MIN_QUALITY;  // Quality drops to 0 after concert
        } else if (item.sellIn < 5) {
            increaseQuality(item, 3);  // Increase by 3 if 5 days or less
        } else if (item.sellIn < 10) {
            increaseQuality(item, 2);  // Increase by 2 if 10 days or less
        } else {
            increaseQuality(item);
        }
    }

    private static void updateRegularItem(Item item) {
        decreaseQuality(item);
    }

    private static void handleExpiredItem(Item item) {
        if (item.name.equals(AGED_BRIE)) {
            increaseQuality(item);
        } else if (item.name.equals(BACKSTAGE_PASSES)) {
            item.quality = MIN_QUALITY;  // Quality drops to 0 after concert
        } else {
            decreaseQuality(item);
        }
    }

    private static void increaseQuality(Item item) {
        increaseQuality(item, 1);
    }

    private static void increaseQuality(Item item, int amount) {
        if (item.quality < MAX_QUALITY) {
            item.quality = Math.min(item.quality + amount, MAX_QUALITY);
        }
    }

    private static void decreaseQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality--;
        }
    }
}
