package com.gildedrose;

public class UpdatableItemFactory {
    public UpdatableItem buildUpdatableItem(Item item) {
        if (item.name.startsWith("Conjured")) {
            item = new Conjured(item);
        } else if (item.name.equals("Aged Brie")) {
            item = new AgedBrie(item);
        } else if (item.name.startsWith("Backstage passes")) {
            item = new BackstagePass(item);
        } else if (item.name.startsWith("Sulfuras")) {
            item = new Sulfuras(item);
        } else {
            item = new Normal(item);
        }
        return (UpdatableItem) item;
    }
}
