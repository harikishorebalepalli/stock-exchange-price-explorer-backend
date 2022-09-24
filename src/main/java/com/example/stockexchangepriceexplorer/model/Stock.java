package com.example.stockexchangepriceexplorer.model;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="prices")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Stock {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @Column(name = "symbol")
  private String name;

  @Column(name = "close")
  private Double closePrice;

  @Column(name = "timestamp")
  private LocalDate date;


}
