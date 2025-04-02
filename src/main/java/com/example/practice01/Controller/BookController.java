package com.example.practice01.Controller;

import com.example.practice01.ApiResponse.ApiResponse;
import com.example.practice01.Model.Book;
import com.example.practice01.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody @Valid Book book, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(message));
        }
        if (bookService.addBook(book).equals("10") || bookService.addBook(book).equals("13"))
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Book is add successfully!"));
        if (bookService.addBook(book).equals("id"))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Book is already exist.."));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Book doesn't match correct ISBN based on date"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable String id,@RequestBody@Valid Book book,Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(message));
        }
        if (bookService.updateBook(id,book))
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Updated!!"));
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable String id){
        if (bookService.deleteBook(id))
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Deleted!!"));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("not found"));
    }

    @PostMapping("/new-version/{id}")
    public ResponseEntity newversion(@PathVariable String id){
        if (bookService.newVersoin(id))
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("new version of your book is added"));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("not found"));
    }

}
