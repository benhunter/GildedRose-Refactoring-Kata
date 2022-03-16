package com.gildedrose;

public class Normal extends UpdatableItem {
    public Normal(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        assert this.quality >= 0;
    }

    public Normal(Item item) {
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
