package com.example.stockexchangepriceexplorer.service;

import com.example.stockexchangepriceexplorer.dao.StockRepo;
import com.example.stockexchangepriceexplorer.model.Stock;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StockService {

  @Autowired
  private StockRepo stockRepo;

  private static final Logger LOGGER = LoggerFactory.getLogger(StockService.class);


  public ResponseEntity<List<Stock>> fetchStockPrices(String stockName, LocalDate startDate, LocalDate endDate){
    try{
      List<Stock> prices;
      if(stockName != null){
        if(startDate != null){
          prices = endDate == null ? this.stockRepo.findAllByNameAndDate(stockName,startDate)
                                    : this.stockRepo.findAllByNameAndDateGreaterThanEqualAndDateLessThanEqual(stockName, startDate,endDate);
        }
        else prices = this.stockRepo.findAllByName(stockName);
      }
      else {
        prices = endDate == null ? this.stockRepo.findAllByDate(startDate)
            : this.stockRepo.findAllByDateGreaterThanEqualAndDateLessThanEqual(startDate,endDate);
      }
      return ResponseEntity.ok(prices);
    }
    catch(Exception e){
      LOGGER.error("Error Fetching stock prices : {}", e);
      return ResponseEntity.status(500).body(null);
    }
  }

}
