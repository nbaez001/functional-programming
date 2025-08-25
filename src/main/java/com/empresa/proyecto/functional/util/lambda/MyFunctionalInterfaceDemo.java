package com.empresa.proyecto.functional.util.lambda;

public class MyFunctionalInterfaceDemo {
    public static void main(String[] args) {
        onTheFly(() -> System.out.println("Hello"));
    }

    public static void onTheFly(MyFunctionalInterface fun) {
        fun.myMethod();
    }
}
