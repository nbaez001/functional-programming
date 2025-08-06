package com.empresa.proyecto.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ListFunctionalOperations {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Spotlight", 2015, "Hollywood"),
                new Movie("Avengers: Infinity War", 2018, "Hollywood"),
                new Movie("Inception", 2010, "Hollywood"),
                new Movie("Forest Gump", 1994, "Hollywood"),
                new Movie("3 Idiots", 2009, "Bollywood"),
                new Movie("Beauty and the beast", 2017, "Hollywood"),
                new Movie("Slumdog Millionaire", 2008, "Bollywood")
        );

        //Traversal
        System.out.println("----- Traversal -----");
        movies.forEach(System.out::println);

        //Sorting
        System.out.println("----- Sorting -----");
        movies.sort((o1, o2) -> o2.getReleaseYear() - o1.getReleaseYear());
        movies.forEach(System.out::println);

        //Filtering
        System.out.println("----- Filtering -----");
        movies.stream()
                .filter(movie -> movie.getIndustry().equalsIgnoreCase("Bollywood"))
                .forEach(System.out::println);

        //Mapping
        System.out.println("----- Mapping -----");
        movies.stream()
                .map(Movie::getName)
                .forEach(System.out::println);

        //Reduce
        System.out.println("----- Reduce -----");
        Optional<String> moviesString = movies.stream()
                .map(Movie::getName)
                .reduce((m1, m2) -> m1 + " | " + m2);
        System.out.println(moviesString);
    }
}