package com.stockmarket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="IPO")
public class IPOs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ipo_id")
	private long id;

	@Column(name="companyname",length=30)
	private String companyname;
	
	@Column(name="Stockexchange",length=30)
	private String stockexchange;
	
	@Column(name="price_pershare",length=30)
	private Double price;
	
	@Column(name="totalshare",length=30)
	private String totalshare;
	
	@Column(name="opentime",length=35)
	private String opentime;
	
	@Column(name="remarks",length=30)
	private String remarks;

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getStockexchange() {
		return stockexchange;
	}

	public void setStockexchange(String stockexchange) {
		this.stockexchange = stockexchange;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getTotalshare() {
		return totalshare;
	}

	public void setTotalshare(String totalshare) {
		this.totalshare = totalshare;
	}

	public String getOpentime() {
		return opentime;
	}

	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}
	
}