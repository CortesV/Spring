package com.devcortes.graphql.service;

import com.devcortes.graphql.model.Author;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AuthorService {

    private static List<Author> authors = Arrays.asList(
            new Author("author-1", "Douglas", "Crockford"),
            new Author("author-2", "Joshua", "Bloch"),
            new Author("author-3", "Robert", "Martin"),
            new Author("author-4", "Nate", "Ebel"),
            new Author("author-5", "David", "Ahl")
    );

    public Author getById(String id) {
        return authors.stream().filter(author -> author.getId().equals(id)).findFirst().orElseGet(null);
    }
}
