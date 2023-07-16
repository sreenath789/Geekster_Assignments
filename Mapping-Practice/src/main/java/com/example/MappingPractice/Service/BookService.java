package com.example.MappingPractice.Service;

import com.example.MappingPractice.Model.Book;
import com.example.MappingPractice.Repo.IAddressRepo;
import com.example.MappingPractice.Repo.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    IBookRepo iBookRepo;

    public void addBook(Book book) {
        iBookRepo.save(book);
    }


    public List<Book> getAllBooks() {
        return iBookRepo.findAll();
    }

    public String updateBook(Integer id, String price) {
        if(iBookRepo.existsById(id)){
            Book book = iBookRepo.findById(id).get();
            book.setPrice(price);
            iBookRepo.save(book);
            return "true";
        }
        return "false";
    }


    public String deleteBook(Integer id) {
        if(iBookRepo.existsById(id)){
            iBookRepo.deleteById(id);
            return "true";
        }
        return "false";
    }
}
