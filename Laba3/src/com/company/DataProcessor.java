package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class DataProcessor {
    public static List<Component> top3Price(ArrayList<Component> list) {
        list.sort(Comparator.comparing(Detail::getPrice).reversed());
        List<Component> top3 = list.stream()
                .filter(element -> element.price < 30)
                .filter(element -> element.price > 10)
                .limit(3)
                .collect(Collectors.toList());

        return top3;
    }

    public static Component searchPrice(ArrayList<Component> list, int price) throws NegativeInput {
        if (price < 0) { throw new NegativeInput("positive number expected"); }

        List<Component> exactPrice = list.stream()
                .filter(element -> element.price == price).toList();

        return exactPrice.get(0);
    }
}
