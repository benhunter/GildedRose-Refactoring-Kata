package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.startsWith("Conjured")) {
                updateQualityForConjuredItem(item);
            } else if (item.name.equals("Aged Brie")) {
                updateQualityForAgedBrie(item);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateQualityForBackstagePasses(item);
            } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                updateQualityForSulfuras(item);
            } else {
                updateQualityForNormalItem(item);
            }
        }
    }

    private void updateQualityForNormalItem(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
            if (item.sellIn <= 0) {
                item.quality -= 1;
            }
        }
        item.sellIn -= 1;
    }

    private void updateQualityForSulfuras(Item item) {
        return;
    }

    private void updateQualityForBackstagePasses(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality += 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality += 1;
                }
            }
        }

        if (item.sellIn <= 0) {
            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                item.quality = 0;
            }
        }

        item.sellIn -= 1;
    }

    private void updateQualityForAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }

        if (item.sellIn <= 0) {
            if (item.quality < 50) {
                item.quality += 1;
            }
        }

        item.sellIn -= 1;
    }

    private void updateQualityForConjuredItem(Item item) {
        assert item.name.startsWith("Conjured");

        if (item.quality > 0) {
            if (item.sellIn > 0) {
                item.quality -= 2;
            } else {
                item.quality -= 4;
            }
        }

        if (item.quality < 0) {
            item.quality = 0;
        }

        item.sellIn -= 1;
    }
}
