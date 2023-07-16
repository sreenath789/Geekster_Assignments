package com.example.MappingPractice.Controller;

import com.example.MappingPractice.Model.Book;
import com.example.MappingPractice.Service.AddressService;
import com.example.MappingPractice.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("book")
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @GetMapping("books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PutMapping("book/{id}/price/{price}")
    public String updateBook(@PathVariable Integer id,@PathVariable String price){
        return bookService.updateBook(id,price);
    }

    @DeleteMapping("book/{id}")
    public String deleteBook(@PathVariable Integer id){
        return bookService.deleteBook(id);
    }
}
