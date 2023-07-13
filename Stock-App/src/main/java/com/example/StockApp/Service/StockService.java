package com.example.StockApp.Service;

import com.example.StockApp.Model.Stock;
import com.example.StockApp.Model.StockType;
import com.example.StockApp.Repo.IStockRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    IStockRepo iStockRepo;

    public List<Stock> getAllStocks() {
        return iStockRepo.findAll();
    }

    public void createStock(Stock stock) {
        iStockRepo.save(stock);
    }

    public void deleteStockById(Long id) {
        if(iStockRepo.existsById(id)){
            iStockRepo.deleteById(id);
        }
    }

    public List<Stock> getStocksByTypePriceDescSorted(StockType type) {
        return iStockRepo.findByStockTypeOrderByStockPriceDesc(type);
    }

    public List<Stock> getStocksRegisteredTime() {
        return iStockRepo.findByOrderByRegisteredTime();
    }

    @Transactional
    public void updateStocksByType(StockType type, Float hike) {
        iStockRepo.updateStocksByType(type.name(),hike);
    }
}
