package com.example.MappingPractice.Repo;

import com.example.MappingPractice.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepo extends JpaRepository<Address,Integer> {
}
