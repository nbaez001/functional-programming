package com.empresa.proyecto.functional.util.methodreference;

import java.util.function.Supplier;

public class MethodRefPractice2 {
    public static void main(String[] args) {
        Supplier<Double> randomNumber = Math::random;
        System.out.println(randomNumber.get());
    }
}
