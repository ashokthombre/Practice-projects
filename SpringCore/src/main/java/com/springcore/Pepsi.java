package com.springcore;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Pepsi  {

    private int price;

    public Pepsi() {
    }

    public Pepsi(int price) {
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
        return "Pepsi{" +
                "price=" + price +
                '}';
    }
    @PostConstruct
  public void start()
  {
      System.out.println("start..");
  }

  @PreDestroy
  public void end()
  {
      System.out.println("end...");
  }
}
