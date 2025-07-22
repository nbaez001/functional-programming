package com.empresa.proyecto.spliterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ReadingObjectsFromFile {
    public static void main(String[] args) {
        Path path = Paths.get("D:/proyectos/functional-programming/src/main/java/com/empresa/proyecto/spliterator/books.txt");
        try (Stream<String> lines = Files.lines(path)) {
            Spliterator<String> baseSpliterator = lines.spliterator();
            Spliterator<Book> spliterator = new BookSpliterator(baseSpliterator);

            Stream<Book> stream = StreamSupport.stream(spliterator, false);
            stream.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class BookSpliterator implements Spliterator<Book> {
    private String name;
    private String author;
    private String genre;
    private double rating;
    private Spliterator<String> baseSpliterator;

    public BookSpliterator(Spliterator<String> baseSpliterator) {
        this.baseSpliterator = baseSpliterator;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Book> action) {
        if (this.baseSpliterator.tryAdvance(name -> this.name = name) &&
                this.baseSpliterator.tryAdvance(author -> this.author = author) &&
                this.baseSpliterator.tryAdvance(genre -> this.genre = genre) &&
                this.baseSpliterator.tryAdvance(rating -> this.rating = Double.parseDouble(rating))) {
            action.accept(new Book(this.name, this.author, this.genre, this.rating));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Spliterator<Book> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return this.baseSpliterator.estimateSize() / 4;
    }

    @Override
    public int characteristics() {
        return this.baseSpliterator.characteristics();
    }
}


class Book {
    private String name;
    private String author;
    private String genre;
    private double rating;

    public Book(String name, String author, String genre, double rating) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                '}';
    }
}
