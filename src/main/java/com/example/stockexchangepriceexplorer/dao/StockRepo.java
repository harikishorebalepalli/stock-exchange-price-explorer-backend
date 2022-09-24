package com.example.stockexchangepriceexplorer.dao;

import com.example.stockexchangepriceexplorer.model.Stock;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface StockRepo extends CrudRepository<Stock,Integer> {

  List<Stock> findAllByName(String name);

  List<Stock> findAllByDate(LocalDate date);

  List<Stock> findAllByNameAndDate(String name, LocalDate startDate);

  List<Stock> findAllByDateGreaterThanEqualAndDateLessThanEqual(LocalDate startDate, LocalDate endDate);

  List<Stock> findAllByNameAndDateGreaterThanEqualAndDateLessThanEqual(String name, LocalDate startDate, LocalDate endDate);



}
