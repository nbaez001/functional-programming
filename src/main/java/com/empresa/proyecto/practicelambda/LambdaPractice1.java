package com.empresa.proyecto.practicelambda;

public class LambdaPractice1 {
    public static void main(String[] args) {
        Name name = () -> System.out.println("Nerio");
        name.myname();
    }
}

@FunctionalInterface
interface Name {
    void myname();
}
