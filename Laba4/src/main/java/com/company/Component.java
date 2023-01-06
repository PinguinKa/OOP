package com.company;

public class Component extends Detail {
    public Component(int type, int price, int power) {
        this.type = type;
        this.price = price;
        this.power = power;
    }

    public void printInfo() {
        System.out.println("Компонент: тип " + type + ", цена " + price + ", мощность: " + power);
    }
}
