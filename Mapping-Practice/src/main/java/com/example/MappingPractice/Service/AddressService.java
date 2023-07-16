package com.example.MappingPractice.Service;

import com.example.MappingPractice.Repo.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    IAddressRepo iAddressRepo;
}
