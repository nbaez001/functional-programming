package com.empresa.proyecto.functionalprogramming;

public class Demo {
    public static void main(String[] args) {
        int result = add(multiply(2, 3), multiply(3, 4));
        System.out.println(result);

        // When the input are modified the result of the program is also changed (logs are no printed)
        int result2 = add(6, 12);
        System.out.println(result2);
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int multiply(int a, int b) {
        log(String.format("Returning %s as the result of %s * %s", a * b, a, b));
        return a * b;
    }

    public static void log(String m) {
        System.out.println(m);
    }
}
