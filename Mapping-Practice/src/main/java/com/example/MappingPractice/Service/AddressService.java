package com.example.MappingPractice.Service;

import com.example.MappingPractice.Model.Address;
import com.example.MappingPractice.Repo.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    IAddressRepo iAddressRepo;

    public void addAddress(Address address) {
        iAddressRepo.save(address);
    }

    public List<Address> getAllAddresses() {
        return iAddressRepo.findAll();
    }

    public String updateAddress(Integer id, String state) {
        if(iAddressRepo.existsById(id)){
            Address address = iAddressRepo.findById(id).get();
            address.setState(state);
            iAddressRepo.save(address);
            return "true";
        }
        return "false";
    }

    public String deleteAddress(Integer id) {
        if(iAddressRepo.existsById(id)){
            iAddressRepo.deleteById(id);
            return "true";
        }
        return "false";
    }
}
