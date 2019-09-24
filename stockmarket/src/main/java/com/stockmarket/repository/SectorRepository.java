package com.stockmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockmarket.model.Sector;

public interface SectorRepository extends JpaRepository<Sector, Long> {
	
}
