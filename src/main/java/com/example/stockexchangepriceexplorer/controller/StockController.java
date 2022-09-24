package com.example.stockexchangepriceexplorer.controller;


import com.example.stockexchangepriceexplorer.model.Stock;
import com.example.stockexchangepriceexplorer.service.StockService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/stock")
public class StockController {

  @Autowired
  private StockService stockService;

  private static final Logger LOGGER = LoggerFactory.getLogger(StockController.class);

  @GetMapping("/prices")
  public ResponseEntity<List<Stock>> fetchStockPrices(@RequestParam(required = false) String stockName, @RequestParam(required = false)
   String startDate, @RequestParam(required = false)  String endDate) throws ParseException {
      LocalDate start = null,  end = null;
      if(startDate != null) start =  LocalDate.parse(startDate);
      if(endDate != null) end = LocalDate.parse(endDate);
      System.out.println(start +" "+end);
      LOGGER.info("Request received for fetching stock prices");
      return stockService.fetchStockPrices(stockName,start,end);
  }

}
