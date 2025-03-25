package com.example.practice01.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Book {

    @NotEmpty(message = "ID cannot be empty")

    private String id;
    @NotEmpty(message = "ISBN cannot be empty")

    private String isbn;
    @NotEmpty(message = "Title cannot be empty")

    private String title;
    @NotEmpty(message = "Author cannot be empty")

    private String author;
    @NotEmpty(message = "Author cannot be empty")

    private LocalDate publicationDate;
    @NotNull(message = "Price cannot be null")

    private double price;

}
