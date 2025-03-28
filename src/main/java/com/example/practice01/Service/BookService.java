package com.example.practice01.Service;

import com.example.practice01.Model.Book;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class BookService {

    ArrayList<Book> books = new ArrayList<>();


    public ArrayList<Book> getBooks() {
        return books;
    }

    public String addBook(Book book){
        for (Book b: books){
            if (b.getId().equals(book.getId())){
                return "id";
            }
        }
        LocalDate date = LocalDate.parse(book.getPublicationDate());
        if (date.isBefore(LocalDate.of(2007,01,01)) && book.getIsbn().length()==10) {
            books.add(book);
            return "10";
        }
        if (date.isAfter(LocalDate.of(2007,01,01)) && book.getIsbn().length()==13){
            books.add(book);
            return "13";
        }
        return "";
    }

    public boolean updateBook(String id,Book book){
        for (Book b:books){
            if (b.getId().equals(id)){
                books.set(books.indexOf(b), book);
                return true;
            }
        }
        return false;
    }

    public boolean deleteBook (String id){
        for (Book b: books){
            if (b.getId().equals(id)){
                books.remove(b);
                return true;
            }
        }
        return false;
    }

}
