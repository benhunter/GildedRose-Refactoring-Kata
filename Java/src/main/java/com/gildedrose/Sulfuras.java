package com.gildedrose;

public class Sulfuras extends UpdatableItem {
    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        assert this.name.startsWith("Sulfuras");
    }

    public Sulfuras(Item item) {
        super(item.name, item.sellIn, item.quality);
        assert this.name.startsWith("Sulfuras");
    }

    @Override
    public void update() {
        return;
    }
}
