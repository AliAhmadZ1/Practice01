package com.example.practice01.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Book {

    @NotEmpty(message = "ID cannot be empty")
    @Size(min = 2,max = 4,message = "ID should be 2-4 character")
    @Pattern(regexp = "^([a-z]|[A-Z]|[0-9])+$",message = "letter and digits only!")
    private String id;
    @NotEmpty(message = "ISBN cannot be empty")
    @Size(min = 10,message = "ISBN should be 10 digit or 13")
    private String isbn;
    @NotEmpty(message = "Title cannot be empty")
    @Pattern(regexp = "^([a-z]|[A-Z])+$",message = "only letters..")
    private String title;
    @NotEmpty(message = "Author cannot be empty")
    private String author;
//    @NotEmpty(message = "Author cannot be empty")
//    @JsonFormat(pattern = "yyyy/MM/dd")
    private String publicationDate = "2007-05-01";
    @NotNull(message = "Price cannot be null")
    @PositiveOrZero(message = "price shouldn't be negative")
    private double price;

}
