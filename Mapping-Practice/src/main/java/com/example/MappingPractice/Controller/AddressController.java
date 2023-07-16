package com.example.MappingPractice.Controller;

import com.example.MappingPractice.Model.Address;
import com.example.MappingPractice.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

   

    @PostMapping("address")
    public void addAddress(@RequestBody Address address){
        addressService.addAddress(address);
    }

    @GetMapping("addresses")
    public List<Address> getAlladdresses(){
        return addressService.getAllAddresses();
    }

    @PutMapping("address/{id}/state/{state}")
    public String updateAddress(@PathVariable Integer id,@PathVariable String state){
        return addressService.updateAddress(id,state);
    }

    @DeleteMapping("address/{id}")
    public String deleteAddress(@PathVariable Integer id){
        return addressService.deleteAddress(id);
    }
}
