package com.empresa.proyecto.functional.util.collections;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SetFunctionalOperations {
    public static void main(String[] args) {
        Set<Integer> set = Set.of(3, 56, 7, 82, 39);

        //Traversal
        System.out.println("----- Traversal -----");
        set.forEach(System.out::println);

        //Filtering
        System.out.println("----- Filtering -----");
        set.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        //Sorting
        System.out.println("----- Sorting -----");
        set.stream()
                .sorted()
                .forEach(System.out::println);

        //Mapping
        System.out.println("----- Mapping -----");
        Set<Double> hashSet = set.stream()
                .map(Integer::doubleValue)
                .collect(Collectors.toCollection(TreeSet::new));
        hashSet.forEach(System.out::println);

        //Reduce
        System.out.println("----- Reduce -----");
        int sum = set.stream()
                .mapToInt(e -> e)
                .sum();
        System.out.println(sum);
    }
}
