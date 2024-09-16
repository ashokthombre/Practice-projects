package com.springcore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class Person {

    @Value("Ashoka")
   private String personName;
   @Value("Mumbai")
   private String personCity;

   @Value("{Ashoka,Sandip,Prashant}")
   private List<String> address;

    public Person() {
    }

    public Person(String personName, String personCity) {
        this.personName = personName;
        this.personCity = personCity;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personName='" + personName + '\'' +
                ", personCity='" + personCity + '\'' +
                '}';
    }

    public String getPersonCity() {
        return personCity;
    }

    public void setPersonCity(String personCity) {
        this.personCity = personCity;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }
}
