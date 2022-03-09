package com.gildedrose;

public class NormalItem extends Item implements UpdatableItem {
    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        assert this.quality >= 0;
    }

    public NormalItem(Item item) {
        super(item.name, item.sellIn, item.quality);
        assert this.quality >= 0;
    }

    @Override
    public void update() {
        if (this.quality > 0) {
            this.quality -= 1;
            if (this.sellIn <= 0) {
                this.quality -= 1;
            }
        }
        this.sellIn -= 1;
    }
}
