package com.example.practice01.Service;

import com.example.practice01.Model.Book;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

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

    public boolean newVersoin (String id) {
        LocalDate date = LocalDate.now();
        Random random = new Random();
        int num = random.nextInt(13);
        for (Book b : books) {
            if (b.getId().equals(id)) {
                Book b2 = new Book(b.getId() + b.getVersion()+1, String.valueOf(num), b.getTitle() + " 2",
                        b.getAuthor(), String.valueOf(date), b.getPrice(),b.getVersion()+1);
                books.add(b2);
                return true;
            }
        }
        return false;
    }


}
