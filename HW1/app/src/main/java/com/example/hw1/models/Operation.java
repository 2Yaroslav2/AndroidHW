package com.example.hw1.models;

public class Operation {

    public String addition(double a, double b)
    {
        return String.valueOf(a + b);
    }

    public String division(double a, double b)
    {
        double res = 0;

        if (a == 0 || b == 0)
        {
            res = 0;
        }
        else res = a / b;
        return String.valueOf(res);
    }

    public String multiplication(double a, double b)
    {
        return String.valueOf(a * b);
    }

    public String subtraction(double a, double b)
    {
        return String.valueOf(a - b);
    }
}
