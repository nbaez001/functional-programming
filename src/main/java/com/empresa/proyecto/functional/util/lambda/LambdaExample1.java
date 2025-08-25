package com.empresa.proyecto.functional.util.lambda;

public class LambdaExample1 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("Thread executed!"));
        t.start();
    }
}
