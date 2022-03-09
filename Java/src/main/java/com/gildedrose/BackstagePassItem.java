package com.gildedrose;

public class BackstagePassItem extends Item implements UpdatableItem {
    public BackstagePassItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        assert this.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    public BackstagePassItem(Item item) {
        super(item.name, item.sellIn, item.quality);
        assert this.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    @Override
    public void update() {
        if (this.quality < 50) {
            this.quality += 1;

            if (this.sellIn < 11) {
                this.quality += 1;
            }

            if (this.sellIn < 6) {
                this.quality += 1;
            }

            if (this.quality > 50) {
                this.quality = 50;
            }
        }

        if (this.sellIn <= 0) {
            this.quality = 0;
        }

        this.sellIn -= 1;
    }
}
