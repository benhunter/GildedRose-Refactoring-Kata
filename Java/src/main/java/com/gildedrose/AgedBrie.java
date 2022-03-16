package com.gildedrose;

public class AgedBrie extends UpdatableItem {
    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        assert this.name.equals("Aged Brie");
    }

    public AgedBrie(Item item) {
        super(item.name, item.sellIn, item.quality);
        assert this.name.equals("Aged Brie");
    }

    @Override
    public void update() {
        if (this.quality < 50) {
            this.quality += 1;
        }

        if (this.sellIn <= 0) {
            if (this.quality < 50) {
                this.quality += 1;
            }
        }

        this.sellIn -= 1;
    }
}
