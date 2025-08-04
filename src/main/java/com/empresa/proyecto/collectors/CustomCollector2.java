package com.empresa.proyecto.collectors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

public class CustomCollector2 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 6, 8, 9, 0, 1, 52, 5, 61, 8, 9, 96, 0, 18, 23);

        // SortedListCollector
        Collector<Integer, List<Integer>, List<Integer>> toSortedList = Collector.of(
                ArrayList::new, //Supplier
                List::add, //BiConsumer
                (list1, list2) -> {
                    list1.addAll(list2);
                    return list1;
                }, //BiFunction
                (list) -> {
                    Collections.sort(list);
                    return list;
                }, //Function
                Collector.Characteristics.UNORDERED
        );

        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(toSortedList);
        System.out.println(evens);
    }
}
