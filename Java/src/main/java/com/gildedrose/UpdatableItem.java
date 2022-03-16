package com.gildedrose;

public abstract class UpdatableItem extends Item implements Updatable {
    public UpdatableItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public abstract void update();
}
