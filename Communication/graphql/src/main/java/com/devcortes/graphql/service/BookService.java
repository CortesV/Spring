package com.devcortes.graphql.service;

import com.devcortes.graphql.model.Book;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookService {

    private static List<Book> books = Arrays.asList(
            new Book("book-1", "JavaScript: The Good Parts", 180, "author-1"),
            new Book("book-2", "Effective Java", 412, "author-2"),
            new Book("book-3", "Clean Code", 464, "author-3"),
            new Book("book-4", "Mastering Kotlin", 434, "author-4"),
            new Book("book-5", "BASIC Computer Games Volume II", 206, "author-5")
            // Add your favourite book here
    );

    public Book getById(String id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElseGet(null);
    }
}
