package com.stockmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockmarket.model.IPOs;

public interface IPOsRepository extends JpaRepository<IPOs, Long> {
	
}
