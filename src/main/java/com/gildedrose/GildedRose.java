package com.gildedrose;

public class GildedRose {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdateStrategy strategy = ItemUpdateStrategyFactory.getStrategy(item);
            strategy.update(item);
        }
    }
}
