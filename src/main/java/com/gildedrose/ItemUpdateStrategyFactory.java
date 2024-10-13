package com.gildedrose;

import com.gildedrose.strategies.*;

public class ItemUpdateStrategyFactory {
    public static ItemUpdateStrategy getStrategy(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrieStrategy();
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePassesStrategy();
            case "Sulfuras, Hand of Ragnaros":
                return new SulfurasStrategy();
            case "Conjured":
                return new ConjuredItemStrategy();
            default:
                return new RegularItemStrategy();
        }
    }
}
