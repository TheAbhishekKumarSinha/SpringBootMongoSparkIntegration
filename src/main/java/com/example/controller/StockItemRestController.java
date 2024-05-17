package com.example.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.StockItem;
import com.example.repositories.StockRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@ResponseBody
public class StockItemRestController {
    
    @Autowired
    private StockRepository stockRepository;

    @GetMapping("/stockItems")
    public List<StockItem> getAllStockItems() {
        return stockRepository.findAll();
    } 

    @GetMapping("/stockItems/{ticker}")
    public List<StockItem> getStockItemByTicker(@PathVariable String ticker) {
        return stockRepository.findByTicker(ticker);
    } 
}
