package com.spring.mvc.service;

public class CalculateService {

    public static int addTwoNumbers(int a,int b)
    {

        return a+b;
    }

    public static int subTwoNumbers(int a,int b)
    {

        return a-b;
    }

    public static double mulTwoNumbers(double a,double b)
    {
        return a*b;
    }

    public static double divTwoNumbers(double a,double b)
    {
        return a/b;
    }

    public static int sum(int...numbers)
    {
        int sum=0;
        for (int a:numbers)
        {
            sum=sum+a;
        }
        return sum;
    }
}
