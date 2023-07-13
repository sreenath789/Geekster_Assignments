package com.example.StockApp.Controller;

import com.example.StockApp.Model.Stock;
import com.example.StockApp.Model.StockType;
import com.example.StockApp.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping("stocks")
    public List<Stock> getAllStocks(){
        return stockService.getAllStocks();
    }

    @PostMapping("stock")
    public void createStock(@RequestBody Stock stock){
        stockService.createStock(stock);
    }

    @DeleteMapping("stock/{id}")
    public void deleteStockById(@PathVariable Long id){
        stockService.deleteStockById(id);
    }

    @GetMapping("stocks/type/{type}")
    public List<Stock> getStocksByTypePriceDescSorted(@PathVariable StockType type){
        return stockService.getStocksByTypePriceDescSorted(type);
    }

    @GetMapping("stocks/timestamp")
    public List<Stock> getStocksRegisteredTime(){
        return stockService.getStocksRegisteredTime();
    }

    @PutMapping("stock/type/{type}/increment/{hike}")
    public String updateStocksByType(@PathVariable StockType type,@PathVariable Float hike){
        stockService.updateStocksByType(type,hike);
        return "Updated";
    }
}
