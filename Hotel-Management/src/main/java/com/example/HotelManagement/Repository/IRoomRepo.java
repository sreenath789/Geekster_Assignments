package com.example.HotelManagement.Repository;

import com.example.HotelManagement.Entity.HotelRoom;
import org.springframework.data.repository.CrudRepository;

public interface IRoomRepo extends CrudRepository<HotelRoom,Long> {
}
