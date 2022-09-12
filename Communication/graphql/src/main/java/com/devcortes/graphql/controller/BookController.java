package com.devcortes.graphql.controller;

import com.devcortes.graphql.model.Author;
import com.devcortes.graphql.model.Book;
import com.devcortes.graphql.service.AuthorService;
import com.devcortes.graphql.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final AuthorService authorService;
    private final BookService bookService;

    @QueryMapping
    public Book bookById(@Argument String id) {
        return bookService.getById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        return authorService.getById(book.getAuthorId());
    }
}
