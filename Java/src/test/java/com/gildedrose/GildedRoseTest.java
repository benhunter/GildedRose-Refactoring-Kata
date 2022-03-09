package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    static Stream<Arguments> provideParametersForUpdateQuality() {
        return Stream.of(

            // foo quality never goes below 0
            Arguments.of("foo", 2, 2, 1, 1),
            Arguments.of("foo", 1, 1, 0, 0),
            Arguments.of("foo", 0, 0, -1, 0),
            Arguments.of("foo", -1, 0, -2, 0),

            // bar quality decreases by 1 until sellIn is 0, then decreases by 2
            Arguments.of("bar", 1, 5, 0, 4),
            Arguments.of("bar", 0, 4, -1, 2),
            Arguments.of("bar", -1, 2, -2, 0),

            // Aged Brie increases with age
            Arguments.of("Aged Brie", 3, 5, 2, 6),
            Arguments.of("Aged Brie", 2, 6, 1, 7),
            Arguments.of("Aged Brie", 1, 7, 0, 8),

            // Aged Brie quality increases by 2 after sellIn reaches 0
            Arguments.of("Aged Brie", 0, 8, -1, 10),
            Arguments.of("Aged Brie", -1, 10, -2, 12),

            // Aged Brie quality does not exceed 50
            Arguments.of("Aged Brie", 5, 49, 4, 50),
            Arguments.of("Aged Brie", 4, 50, 3, 50),

            // Sulfuras, Hand of Ragnaros
            Arguments.of("Sulfuras, Hand of Ragnaros", 1, 80, 1, 80),
            Arguments.of("Sulfuras, Hand of Ragnaros", 0, 80, 0, 80),
            Arguments.of("Sulfuras, Hand of Ragnaros", -1, 80, -1, 80),

            // Backstage passes to a TAFKAL80ETC concert
            Arguments.of("Backstage passes to a TAFKAL80ETC concert", 11, 1, 10, 2),
            Arguments.of("Backstage passes to a TAFKAL80ETC concert", 10, 2, 9, 4),
            Arguments.of("Backstage passes to a TAFKAL80ETC concert", 9, 4, 8, 6),
            Arguments.of("Backstage passes to a TAFKAL80ETC concert", 6, 1, 5, 3),
            Arguments.of("Backstage passes to a TAFKAL80ETC concert", 5, 3, 4, 6),
            Arguments.of("Backstage passes to a TAFKAL80ETC concert", 4, 6, 3, 9),
            Arguments.of("Backstage passes to a TAFKAL80ETC concert", 1, 6, 0, 9),
            Arguments.of("Backstage passes to a TAFKAL80ETC concert", 0, 6, -1, 0),

            // quality can't go above 50
            Arguments.of("Backstage passes to a TAFKAL80ETC concert", 11, 49, 10, 50),
            Arguments.of("Backstage passes to a TAFKAL80ETC concert", 10, 49, 9, 50),
            Arguments.of("Backstage passes to a TAFKAL80ETC concert", 6, 49, 5, 50),
            Arguments.of("Backstage passes to a TAFKAL80ETC concert", 5, 49, 4, 50),
            Arguments.of("Backstage passes to a TAFKAL80ETC concert", 1, 49, 0, 50),
            Arguments.of("Backstage passes to a TAFKAL80ETC concert", 1, 50, 0, 50),
            Arguments.of("Backstage passes to a TAFKAL80ETC concert", 0, 49, -1, 0),
            Arguments.of("Backstage passes to a TAFKAL80ETC concert", 0, 50, -1, 0),

            // Conjured Mana Cake
            Arguments.of("Conjured Mana Cake", 3, 6, 2, 4),
            Arguments.of("Conjured Mana Cake", 2, 4, 1, 2),
            Arguments.of("Conjured Mana Cake", 1, 2, 0, 0),
            Arguments.of("Conjured Mana Cake", 1, 1, 0, 0),
            Arguments.of("Conjured Mana Cake", 0, 0, -1, 0),
            Arguments.of("Conjured Mana Cake", 1, 8, 0, 6),
            Arguments.of("Conjured Mana Cake", 0, 6, -1, 2),
            Arguments.of("Conjured Mana Cake", -1, 2, -2, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParametersForUpdateQuality")
    void updateQuality_parameterized(String name, int startSellIn, int startQuality, int expectedSellIn, int expectedQuality) {
        Item[] itemList = new Item[]{new Item(name, startSellIn, startQuality)};
        GildedRose app = new GildedRose(itemList);
        app.updateQuality();
        assertEquals(expectedSellIn, app.getItems()[0].sellIn);
        assertEquals(expectedQuality, app.getItems()[0].quality);
    }

}
