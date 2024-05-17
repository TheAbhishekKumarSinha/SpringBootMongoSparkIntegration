package com.example.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.StockItem;
import com.example.repositories.StockRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@ResponseBody
public class StockItemRestController {

    private final List<String> buySellFlagList = Arrays.asList("B", "S");
    private final List<String> tenorList = Arrays.asList("1Y", "2Y", "3Y", "4Y", "5Y", "6Y", "7Y", "8Y", "9Y");
    private final List<String> deskList = Arrays.asList("CREDIT","RATES");
    private final List<String> includedList = Arrays.asList("Y","N");
    private final String randomString = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private final List<String> portFolioList = Arrays.asList("UKAUBOND", "UKINBOND", "MONA", "SOGBOND", "ALIS");

    
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

    @GetMapping("/addStockItem")
    public void addStockItem() {
        
        // for(int i=0; i<1000;i++){
        //     StockItem item = getStockItem();
        //     //stockRepository.save(item);
        // }
        
    }

    private StockItem getStockItem() {
        Random random = new Random();
        String ticker = getRandomString(8, random);
        StockItem  stockItem = StockItem.builder()
        .buySellFlag(this.buySellFlagList.get(random.nextInt(buySellFlagList.size()-1)))
        .quantity(random.nextDouble(1000, 10000000))
        .scbDirection(this.buySellFlagList.get(random.nextInt(buySellFlagList.size()-1)))
        .quantityUsd(random.nextDouble(1000, 100000))
        .creationdateinutc(random.nextLong(1672531200000L, 1715945878969L))
        .included(this.includedList.get(random.nextInt(includedList.size()-1)))
        .portfolio(this.portFolioList.get(random.nextInt(portFolioList.size()-1)))
        .desk(this.deskList.get(random.nextInt(deskList.size()-1)))
        .cusip(""+randomString.charAt(random.nextInt(randomString.length()-1))+randomString.charAt(random.nextInt(randomString.length()-1))+random.nextInt(10000,99999))
        .ticker(ticker)
        .description(ticker + " "+ random.nextInt(10)+ "/"+ random.nextInt(10) +" "+ random.nextInt(29)+ "/" +random.nextInt(12) + "/" +random.nextInt(23))
        .isin(getRandomString(2, random)+random.nextInt(10000000,99999999))

        .build();

        return stockItem;
    }

    private String getRandomString(int i, Random random ) {
        
        StringBuilder stringBuilder= new StringBuilder();
        for (int  j=0;j<i;j++){
            stringBuilder.append(randomString.charAt(random.nextInt(randomString.length()-1)));
        }

        return stringBuilder.toString();
    } 
}
