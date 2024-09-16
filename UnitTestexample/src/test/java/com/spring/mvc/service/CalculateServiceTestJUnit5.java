package com.spring.mvc.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculateServiceTestJUnit5 {


    @BeforeAll
    public static void init()
    {
        System.out.println("Init method");
    }

    @Test
    public void addTwoNumbersTest()
    {
        System.out.println("Test case first...");
        int result = CalculateService.addTwoNumbers(10, 20);
        int expected=30;
        Assertions.assertEquals(expected,result);

    }

    @Test
    public void sum()
    {
        System.out.println("Test case second..");
        int sum = CalculateService.sum(1, 2, 3, 4);
        int expected=10;
        Assertions.assertEquals(expected,sum);
    }

    @AfterAll
    public static void cleanup()
    {
        System.out.println("After all");
    }
}
