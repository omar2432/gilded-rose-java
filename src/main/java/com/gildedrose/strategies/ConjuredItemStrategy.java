package com.gildedrose.strategies;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdateStrategy;

public class ConjuredItemStrategy implements ItemUpdateStrategy {
    @Override
    public void update(Item item) {
        item.sellIn--;
        decreaseQuality(item, 2);
        if (item.sellIn < 0) {
            decreaseQuality(item, 2);
        }
    }

    private void decreaseQuality(Item item, int amount) {
        item.quality = Math.max(item.quality - amount, 0);
    }
}
