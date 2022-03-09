package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void itemConstructsAndToString() {
        Item item = new Item("test", 4, 2);
        assertEquals("test, 4, 2", item.toString());
    }

}
