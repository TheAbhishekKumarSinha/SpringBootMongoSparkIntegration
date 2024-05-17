package com.example.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.pojo.StockItem;

public interface StockRepository extends MongoRepository<StockItem, String> {

    public StockItem findByIsin(String isin);
    public List<StockItem> findByTicker(String ticker);

    public List<StockItem> findAll();
    
}
