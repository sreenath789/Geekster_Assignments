package com.example.HotelManagement.Service;

import com.example.HotelManagement.Entity.HotelRoom;
import com.example.HotelManagement.Repository.IRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    @Autowired
    IRoomRepo iRoomRepo;
    public Iterable<HotelRoom> getAllRooms() {
        return iRoomRepo.findAll();
    }

    public String addRoom(HotelRoom hotelRoom) {
        iRoomRepo.save(hotelRoom);
        return "Room Added Successfully!";
    }
}
