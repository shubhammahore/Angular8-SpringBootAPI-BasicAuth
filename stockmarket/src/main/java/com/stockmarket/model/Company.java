package com.stockmarket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="companyname",length=30)
	private String companyname;
	
	@Column(name="turnover",length=30)
	private String turnover;
	
	@Column(name="CEO",length=30)
	private String CEO;
	
	@Column(name="boardofdirec",length=30)
	private String boardofdirec;
	
	@Column(name="listedinstock",length=30)
	private String listedinstock;
	
	@Column(name="sector",length=30)
	private String sector;
	
	@Column(name="about",length=30)
	private String about;
	
	@Column(name="stockcode" ,length=38)
	private String stockcode;

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getTurnover() {
		return turnover;
	}

	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}

	public String getCEO() {
		return CEO;
	}

	public void setCEO(String cEO) {
		CEO = cEO;
	}

	public String getBoardofdirec() {
		return boardofdirec;
	}

	public void setBoardofdirec(String boardofdirec) {
		this.boardofdirec = boardofdirec;
	}

	public String getListedinstock() {
		return listedinstock;
	}

	public void setListedinstock(String listedinstock) {
		this.listedinstock = listedinstock;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getStockcode() {
		return stockcode;
	}

	public void setStockcode(String stockcode) {
		this.stockcode = stockcode;
	}
	
}