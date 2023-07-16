package com.example.MappingPractice.Controller;

import com.example.MappingPractice.Model.Laptop;
import com.example.MappingPractice.Service.AddressService;
import com.example.MappingPractice.Service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {

    @Autowired
    LaptopService laptopService;

    @PostMapping("laptop")
    public void addLaptop(@RequestBody Laptop laptop){
        laptopService.addLaptop(laptop);
    }

    @GetMapping("laptops")
    public List<Laptop> getAllLaptops(){
        return laptopService.getAllLaptops();
    }

    @PutMapping("laptop/{id}/price/{price}")
    public String updateLaptop(@PathVariable Integer id,@PathVariable Integer price){
        return laptopService.updateLaptop(id,price);
    }

    @DeleteMapping("laptop/{id}")
    public String deleteLaptop(@PathVariable Integer id){
        return laptopService.deleteLaptop(id);
    }
}
