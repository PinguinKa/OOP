package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WireTest {
    @Test
    void getInfo() {
        Wire wire = new Wire(5, 5);

        assertEquals("Провод: тип 5, цена 5", wire.getInfo());
        assertNotEquals("Компонент: тип 4, цена 20, мощность 20", wire.getInfo());
    }
}