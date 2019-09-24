package com.stockmarket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StockPrice")

public class StockPrice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "companyCode")
	private long companyCode;
	
	public long getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(long companyCode) {
		this.companyCode = companyCode;
	}

	@Column(name = "stockExchange")
	private String stockExchange;
	
	@Column(name = "currentPrice")
	private String currentPrice;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "time")
	private String time;


	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public String getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(String currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
	