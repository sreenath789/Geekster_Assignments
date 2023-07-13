package com.example.StockApp.Repo;

import com.example.StockApp.Model.Stock;
import com.example.StockApp.Model.StockType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStockRepo extends JpaRepository<Stock,Long> {
    List<Stock> findByStockTypeOrderByStockPriceDesc(StockType type);

    List<Stock> findByOrderByRegisteredTime();

    @Modifying
    @Query(value = "UPDATE STOCK SET STOCK_PRICE = (STOCK_PRICE + STOCK_PRICE*(?2)) WHERE STOCK_TYPE = ?1",nativeQuery = true)
    void updateStocksByType(String name, Float hike);
}
