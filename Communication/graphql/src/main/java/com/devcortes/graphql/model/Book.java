package com.devcortes.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private String id;
    private String name;
    private int pageCount;
    private String authorId;
}
