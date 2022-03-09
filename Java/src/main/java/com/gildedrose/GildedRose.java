package com.gildedrose;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GildedRose {
    private final Item[] items;
    private final UpdatableItem[] updatableItems;

    public GildedRose(Item[] items) {
        List<Item> itemsList = Arrays
            .stream(items)
            .map(item -> itemFactory(item))
            .collect(Collectors.toList());

        this.items = itemsList.toArray(Item[]::new);
        this.updatableItems = itemsList.toArray(UpdatableItem[]::new);
    }

    public Item[] getItems() {
        return items;
    }

    private Item itemFactory(Item item) {
        if (item.name.startsWith("Conjured")) {
            item = new ConjuredItem(item);
        } else if (item.name.equals("Aged Brie")) {
            item = new AgedBrieItem(item);
        } else if (item.name.startsWith("Backstage passes")) {
            item = new BackstagePassItem(item);
        } else if (item.name.startsWith("Sulfuras")) {
            item = new SulfurasItem(item);
        } else {
            item = new NormalItem(item);
        }
        return item;
    }

    public void updateQuality() {
        for (UpdatableItem item : updatableItems) {
            item.update();
        }
    }
}
