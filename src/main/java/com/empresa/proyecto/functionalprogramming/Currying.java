package com.empresa.proyecto.functionalprogramming;

public class Currying {
    public static void main(String[] args) {
        // Function<Integer, Function<Integer, Integer>> fun1 = u -> {
        //     return v -> u + v;
        // };
        Function<Integer, Function<Integer, Integer>> fun1 = u -> v -> u + v;
        Function<Integer, Integer> fun2 = fun1.apply(1);
        Integer sum = fun2.apply(2);
        System.out.println(sum);

        Function<Integer, Function<Integer, Function<Integer, Integer>>> funx1 = u -> v -> w -> u + v + w;
        Function<Integer, Function<Integer, Integer>> funx2 = funx1.apply(1);
        Function<Integer, Integer> funx3 = funx2.apply(2);
        Integer sumx = funx3.apply(3);
        System.out.println(sumx);
    }
}
