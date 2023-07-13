package com.example.StockApp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockId;
    @Column(unique = true)
    private String stockName;
    private Double stockPrice;
    private Integer stockOwnerCount;
    @Enumerated(EnumType.STRING)
    private StockType stockType;
    private LocalDateTime registeredTime;
}
