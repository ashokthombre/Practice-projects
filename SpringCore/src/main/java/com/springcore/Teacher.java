package com.springcore;

public class Teacher {

    private String name;

    private String city;

    public Teacher(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Teacher() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
