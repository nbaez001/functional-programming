package com.empresa.proyecto.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapOperation {
    public static void main(String[] args) {
        // Example 1
        List<Integer> collect = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .map(e -> e * 25)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);

        // Example 2
        List<Book> books = new ArrayList<>();
        books.add(new Book("The Alchemist", "Paulo Coelho", "Adventure", 4.408789797));
        books.add(new Book("The Notebook", "Nicholas Sparks", "Romance", 4.10));
        books.add(new Book("Horror Cocktail", "Robert Bloch", "Horror", 2.67));
        books.add(new Book("House of Leaves", "Mark Z. Danielewski", "Horror", 4.10908908));

        books.stream()
                .filter((book) -> book.getGenre().equalsIgnoreCase("Horror"))
                .filter((book) -> book.getRating() > 3)
                .map(Book::getName)
                .forEach(System.out::println);
    }
}
