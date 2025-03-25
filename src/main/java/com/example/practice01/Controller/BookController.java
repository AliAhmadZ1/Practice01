package com.example.practice01.Controller;

import com.example.practice01.ApiResponse.ApiResponse;
import com.example.practice01.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/get")
    public ResponseEntity getBooks() {
        if (bookService.getBooks().isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("There are no books"));
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooks());
    }

}
