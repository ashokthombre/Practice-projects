package com.springcore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Demo {

    @Value("#{ 12+12 }")
    private int x;

    @Value("#{ 2222+77 }")
    private  int y;

    @Value("#{ T(java.lang.Math).sqrt(25) }")
    private int z;

    @Value("#{T(java.lang.Math).E}")
    private double e;

    @Value("#{T(java.lang.Math).PI}")
    private double pi;

    @Value("#{new java.lang.String('Ashok Thombre')}")
    private String name;

    @Value("#{8>3}")
    private Boolean isActive;


    public Demo() {
    }

    public Demo(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", e=" + e +
                ", pi=" + pi +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
