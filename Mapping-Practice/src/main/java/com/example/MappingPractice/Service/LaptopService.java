package com.example.MappingPractice.Service;

import com.example.MappingPractice.Model.Course;
import com.example.MappingPractice.Model.Laptop;
import com.example.MappingPractice.Repo.IAddressRepo;
import com.example.MappingPractice.Repo.ILaptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    @Autowired
    ILaptopRepo iLaptopRepo;

    public void addLaptop(Laptop laptop) {
        iLaptopRepo.save(laptop);
    }


    public List<Laptop> getAllLaptops() {
        return iLaptopRepo.findAll();
    }

    public String updateLaptop(Integer id, Integer price) {
        if(iLaptopRepo.existsById(id)){
            Laptop laptop = iLaptopRepo.findById(id).get();
            laptop.setPrice(price);
            iLaptopRepo.save(laptop);
            return "true";
        }
        return "false";
    }

    public String deleteLaptop(Integer id) {
        if(iLaptopRepo.existsById(id)){
            iLaptopRepo.deleteById(id);
            return "true";
        }
        return "false";
    }
}
