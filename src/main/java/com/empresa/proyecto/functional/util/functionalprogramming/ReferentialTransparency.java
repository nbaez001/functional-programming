package com.empresa.proyecto.functional.util.functionalprogramming;

public class ReferentialTransparency {
    public static void main(String[] args) {
        int result = add(2, multiply(2, 4));
        System.out.println(result);

        int result2 = add(2, multiply(2, multiply(2, 2)));
        System.out.println(result2);
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int multiply(int a, int b) {
        System.out.println("Multiplying a and b: " + a + ", " + b);
        return a * b;
    }
}