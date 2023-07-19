package com.example.HotelManagement.Controller;

import com.example.HotelManagement.Entity.HotelRoom;
import com.example.HotelManagement.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping("getAllRooms")
    public Iterable<HotelRoom> getAllRooms(){
        return roomService.getAllRooms();
    }

    @PostMapping("addRoom")
    public String addRoom(@RequestBody HotelRoom hotelRoom){
        return roomService.addRoom(hotelRoom);
    }
}
