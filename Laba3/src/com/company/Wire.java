package com.company;

class Wire extends Component {
    public Wire(int type, int price) {
        super(type, price, 0);
    }

    public void printInfo() {
        System.out.println("Провод: тип " + type + ", цена " + price);
    }
}
