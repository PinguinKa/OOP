package com.company;

public class ComputerPart extends Detail {
    public ComputerPart(int type, int price, int power) {
        this.type = type;
        this.price = price;
        this.power = power;
    }

    public void printInfo() {
        System.out.println("Компьютерная часть: тип " + type + ", цена " + price + ", мощность: " + power);
    }
}
