package com.empresa.proyecto.functional.util.predefinedfuncInter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PracticePredicate {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Basics");
        list.add("");
        list.add("Strong");
        list.add("");
        list.add("BasicsStrong");

        Predicate<String> predicate = s -> !s.isEmpty();
        List<String> newList = filterList(list, predicate);
        System.out.println(newList);

        Predicate<String> filter = s -> s.contains("Basics");
        List<String> newList2 = filterList(list, filter);
        System.out.println(newList2);

        List<Integer> intList = List.of(1, 4, 6, 7, 8);

        Predicate<Integer> intFilter = e -> e % 2 == 0;
        List<Integer> evens = filterList(intList, intFilter);
        System.out.println(evens);
    }

    private static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        List<T> newList = new ArrayList<>();
        for (T str : list) {
            if (predicate.test(str)) {
                newList.add(str);
            }
        }
        return newList;
    }
}
