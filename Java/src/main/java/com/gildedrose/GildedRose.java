package com.gildedrose;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GildedRose {
    private final UpdatableItem[] updatableItems;
    private final UpdatableItemFactory factory;

    public GildedRose(Item[] items, UpdatableItemFactory factory) {
        this.factory = factory;

        List<UpdatableItem> itemsList = Arrays
            .stream(items)
            .map(this.factory::buildUpdatableItem)
            .collect(Collectors.toList());

        this.updatableItems = itemsList.toArray(UpdatableItem[]::new);
    }

    public UpdatableItem[] getItems() {
        return updatableItems;
    }

    public void updateQuality() {
        for (UpdatableItem item : updatableItems) {
            item.update();
        }
    }
}
