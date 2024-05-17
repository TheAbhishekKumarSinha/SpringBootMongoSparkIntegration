package com.example.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("EnrichedInquiry")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StockItem {

    @Id
    private String id;
    @Field("QUANTITY")
    private double quantity;
    @Field("BUYSELLFLAG")
    private String buySellFlag;
    @Field("QUANTITY_USD")
    private double quantityUsd;
    @Field("DESCRIPTION")
    private String description;
    @Field("TENOR")
    private String tenor;
    @Field("SEGMENT")
    private String segment; 
    @Field("CUSIP")
    private String cusip;
    @Field("ISIN")
    private String isin;
    @Field("DESK")
    private String desk;
    @Field("PORTFOLIO")
    private String portfolio;
    @Field("INCLUDED")
    private String included;
    @Field("SCBDIRECTION")
    private String scbDirection;
    @Field("CREATIONDATEINUTC")
    private long creationdateinutc;
    @Field("TENOR_BUCKET")
    private String tenorBucket;
    @Field("TICKER")
    private String ticker;
        
        
}