package com.company;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        int[] component = {1, 2, 1, 4, 3, 3, 3, 4};
        int[] price = {10, 15, 20, 25, 20, 15, 30, 20};
        int[] power = {30, 40, 20, 15, 20, 40, 50, 15};

        int max_price = price[0];
        int max_power = power[0];
        int max_type = 1;
        int power_sum = 0;
        int price_sum = 0;
        int count = 0;

        for (int i = 0; i < price.length; i++) {
            max_price = Math.max(max_price, price[i]);
            max_power = Math.max(max_power, power[i]);
            max_type = Math.max(max_type, component[i]);
            price_sum += price[i];
            power_sum += power[i];
        }

        System.out.println("Средняя стоимость:  " + (double) price_sum/price.length);
        System.out.println("Средняя мощность:  " + (double) power_sum/power.length);
        System.out.println("Максимальная стоимость: " + max_price);
        System.out.println("Максимальная мощность: " + max_power);

        for (int i = 1; i <= max_type; i++) {
            price_sum = 0;
            power_sum = 0;
            count = 0;
            for (int j = 0; j < component.length; j++) {
                if (Objects.equals(i, component[j]))  {
                    power_sum += power[j];
                    price_sum += price[j];
                    count += 1;
                };
            }
            if (count != 0){
                System.out.println("Комплектующая типа " + i +
                        ": средняя стоимость: " + (double) price_sum/count +
                        "; средняя мощность: " + (double) power_sum/count);
            }
        }
    }
}
