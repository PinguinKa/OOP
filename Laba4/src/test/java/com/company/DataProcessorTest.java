package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataProcessorTest {
    @Test
    void top3Price() {
        ArrayList<Component> list = new ArrayList<>();
        list.add(new Component(1, 10, 30));
        list.add(new Component(4, 20, 20));
        list.add(new Component(3, 25, 15));
        list.add(new Wire(2, 15));
        list.add(new Wire(3, 30));
        list.add(new Wire(5, 5));
        List<Component> result = DataProcessor.top3Price(list);

        List<Component> rightList = new ArrayList<>();
        rightList.add(new Component(3, 25, 15));
        rightList.add(new Component(4, 20, 20));
        rightList.add(new Wire(2, 15));

        List<Component> wrongList = new ArrayList<>();
        wrongList.add(new Component(1, 10, 30));
        wrongList.add(new Wire(3, 30));
        wrongList.add(new Wire(5, 5));

        assertEquals(rightList.get(0), result.get(0));
        assertEquals(rightList.get(1), result.get(1));
        assertEquals(rightList.get(2), result.get(2));

        assertNotEquals(wrongList.get(0), result.get(0));
        assertNotEquals(wrongList.get(1), result.get(1));
        assertNotEquals(wrongList.get(2), result.get(2));
    }

    @Test
    void searchPrice() throws NegativeInput {
        ArrayList<Component> list = new ArrayList<>();
        list.add(new Component(1, 10, 30));
        list.add(new Component(4, 20, 20));
        list.add(new Component(3, 25, 15));
        list.add(new Wire(2, 15));
        list.add(new Wire(3, 30));
        list.add(new Wire(5, 5));
        Component result = DataProcessor.searchPrice(list, 5);

        Component rightAnswer = new Wire(5, 5);
        Component wrongAnswer = new Component(1, 10, 30);

        assertEquals(rightAnswer, result);
        assertNotEquals(wrongAnswer, result);
    }
}