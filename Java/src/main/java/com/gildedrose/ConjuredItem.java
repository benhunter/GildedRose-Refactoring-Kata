package com.gildedrose;

public class ConjuredItem extends Item implements UpdatableItem {
    public ConjuredItem(Item item) {
        super(item.name, item.sellIn, item.quality);
        assert this.name.startsWith("Conjured");
    }

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        assert this.name.startsWith("Conjured");
    }

    @Override
    public void update() {

        if (this.quality > 0) {
            if (this.sellIn > 0) {
                this.quality -= 2;
            } else {
                this.quality -= 4;
            }
        }

        if (this.quality < 0) {
            this.quality = 0;
        }

        this.sellIn -= 1;
    }
}
