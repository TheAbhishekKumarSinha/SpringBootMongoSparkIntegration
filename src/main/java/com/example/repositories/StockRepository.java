package com.example.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.pojo.StockItem;

public interface StockRepository extends MongoRepository<StockItem, String> {

    public StockItem findByIsin(String isin);
    public List<StockItem> findByTicker(String ticker);

    public List<StockItem> findAll();

    @Query(fields="{ 'ticker' : 1, '_id': 0}")
    public List<String> findByIncluded(String included, Pageable pageable);

    @Query(fields="{ 'isin' : 1, '_id': 0}")
    public List<String> findIsinByIncluded(String included, Pageable pageable);
    
}
