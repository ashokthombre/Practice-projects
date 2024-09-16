package com.springcore;

import org.springframework.stereotype.Component;


public class Pupil {

    private City city;



    public void print()
    {
        this.city.display();
        System.out.println("Print Pupil..");
    }

    public Pupil(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
