package com.example.MappingPractice.Service;

import com.example.MappingPractice.Repo.IAddressRepo;
import com.example.MappingPractice.Repo.ILaptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    @Autowired
    ILaptopRepo iLaptopRepo;
}
