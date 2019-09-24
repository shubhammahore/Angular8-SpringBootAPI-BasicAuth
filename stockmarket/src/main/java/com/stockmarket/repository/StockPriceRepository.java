package com.stockmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockmarket.model.StockPrice;


public interface StockPriceRepository extends JpaRepository<StockPrice, Long> {
	
}