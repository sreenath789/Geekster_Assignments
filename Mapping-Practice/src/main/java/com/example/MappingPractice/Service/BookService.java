package com.example.MappingPractice.Service;

import com.example.MappingPractice.Repo.IAddressRepo;
import com.example.MappingPractice.Repo.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    IBookRepo iBookRepo;
}
