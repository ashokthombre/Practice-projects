package com.springcore;

public class Samosa {

    private int price ;

    public void print ()
    {
        System.out.println("price is "+price);
    }

    public void init()
    {
        System.out.println("Init method..");
    }

    public void destroy()
    {
        System.out.println("Destroy method...");
    }


    public Samosa() {
    }

    public Samosa(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Samosa{" +
                "price=" + price +
                '}';
    }
}
