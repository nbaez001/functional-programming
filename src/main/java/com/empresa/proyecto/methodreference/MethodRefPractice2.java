package com.empresa.proyecto.methodreference;

import java.util.function.Supplier;

public class MethodRefPractice2 {
    public static void main(String[] args) {
        Supplier<Double> randomNumber = Math::random;
        System.out.println(randomNumber.get());
    }
}
