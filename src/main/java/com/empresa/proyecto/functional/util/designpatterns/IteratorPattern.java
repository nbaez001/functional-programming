package com.empresa.proyecto.functional.util.designpatterns;

import java.util.function.Consumer;

public class IteratorPattern {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(new Object[]{1, 3, 5, 67, 8});
        list.forEach(System.out::println);
    }
}

class MyArrayList {
    Object[] elements = new Object[5];

    public MyArrayList(Object[] elements) {
        this.elements = elements;
    }

    public void forEach(Consumer action) {
        for (int i = 0; i < elements.length; i++) {
            action.accept(elements[i]);
        }
    }
}
