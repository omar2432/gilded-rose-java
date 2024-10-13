package com.gildedrose.strategies;

import com.gildedrose.Item;
import com.gildedrose.ItemUpdateStrategy;

public class SulfurasStrategy implements ItemUpdateStrategy {
    @Override
    public void update(Item item) {
        // Sulfuras' quality remains constant
        item.quality = 80;
    }
}
