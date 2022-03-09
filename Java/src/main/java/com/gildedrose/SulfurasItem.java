package com.gildedrose;

public class SulfurasItem extends Item implements UpdatableItem {
    public SulfurasItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        assert this.name.startsWith("Sulfuras");
    }

    public SulfurasItem(Item item) {
        super(item.name, item.sellIn, item.quality);
        assert this.name.startsWith("Sulfuras");
    }

    @Override
    public void update() {
        return;
    }
}
