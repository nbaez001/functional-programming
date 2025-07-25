package com.empresa.proyecto.predefinedfuncInter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionPractice {
    public static void main(String[] args) {
        List<String> list = List.of("Kit", "Kat", "Shake");
        Function<String, Integer> function = e -> e.length();
        List<Integer> newList = map(list, function);
        System.out.println(newList);
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> newList = new ArrayList<>();
        for (T t : list) {
            newList.add(function.apply(t));
        }
        return newList;
    }
}
