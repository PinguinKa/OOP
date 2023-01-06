package com.company;

public abstract class Detail {
    public int type;
    public int price;
    public int power;

    public Integer getType() { return type; }

    public Integer getPrice() { return price; }

    public void printInfo() {}

    @Override public boolean equals(Object obj)
    {
        if (this == obj)
            return true;

        if (obj == null || this.getClass() != obj.getClass())
            return false;

        Detail p1 = (Detail)obj;

        return this.type == p1.type
                && this.price == p1.price
                && this.power == p1.power;
    }
}
