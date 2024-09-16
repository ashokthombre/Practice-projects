package com.actuator;

public class Test {

    public static void main(String[] args) {

        System.out.println("Going to debug app");
        int arr []={2,3,4,5};
        int sum = getSum(arr);
        System.out.println("Sum is "+sum);
    }

    public static int getSum(int []arr)
    {
        int sum=0;
        for (int a:arr)
        {
            sum=sum+a;
        }
        sum=sum+345;
        return sum;
    }
}
