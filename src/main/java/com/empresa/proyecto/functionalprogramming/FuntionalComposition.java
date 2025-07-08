package com.empresa.proyecto.functionalprogramming;

public class FuntionalComposition {
    public static void main(String[] args) {
        Function<Square, Integer> fun1 = s -> s.getArea();
        Function<Integer, Double> fun2 = area -> Math.sqrt(area);
        Function<Square, Double> getSide = fun2.compose(fun1);

        Square s = new Square();
        s.setArea(100);
        Double side = getSide.apply(s);
        System.out.println(side);
    }
}

interface Function<T, R> {
    R apply(T t);

    default <V> Function<V, R> compose(Function<V, T> before) {
        return (V v) -> apply(before.apply(v));
    }
}

class Square {
    private int area;

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
}