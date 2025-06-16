package com.empresa.proyecto.practicelambda;

public class LamndaPractice2 {
    public static void main(String[] args) {
        MathOperation add = (a, b) -> System.out.println(a + b);
        add.operation(2, 4);

        MathOperation multiply = (a, b) -> System.out.println(a * b);
        multiply.operation(2, 4);
    }
}

interface MathOperation {
    void operation(int a, int b);
}
