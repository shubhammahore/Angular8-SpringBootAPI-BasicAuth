package com.stockmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockmarket.model.StockExchange;

public interface StockExchangeRepository extends JpaRepository<StockExchange, Long> {
	
}
