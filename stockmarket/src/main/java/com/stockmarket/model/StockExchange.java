package com.stockmarket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="stock_exchange")
public class StockExchange {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long id;
	
	@NotNull(message = "stock_exchange cannot be null")
	@Column(name = "Stock_exchange")
	@Size(max = 70, message = "Name cannot exceed 70 characters!")
	private String name;
	
	@NotNull(message = "discription cannot be null")
	@Column(name = "about")
	private String brief;
	
	
	@Column(name = "contact_address")
	private String contactAddress;
	@Column(name = "remarks")
	private String Remarks;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}	
	
}
