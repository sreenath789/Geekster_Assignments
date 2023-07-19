package com.example.HotelManagement.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Hotel_Room")
public class HotelRoom {

    @Id
    private Long roomId;
    private String roomNumber;
    private Type roomType;
    private Double roomPrice;
    @Column(name="status")
    private Boolean roomStatus;





}
