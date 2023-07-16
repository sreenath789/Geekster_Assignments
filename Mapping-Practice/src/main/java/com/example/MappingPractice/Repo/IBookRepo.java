package com.example.MappingPractice.Repo;

import com.example.MappingPractice.Model.Address;
import com.example.MappingPractice.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepo extends JpaRepository<Book,Integer> {
}
