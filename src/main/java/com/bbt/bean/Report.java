package com.bbt.bean;

import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.util.List;

public class Report {

	private String companyName;

	private BigDecimal amount;

	private String artistName;

	private String address;

	private String billNumber;

	private String contactEmail;

	private String subject;

	private List<Particular> particulars;

	private java.awt.Image logo;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public List<Particular> getParticulars() {
		return particulars;
	}

	public void setParticulars(List<Particular> particulars) {
		this.particulars = particulars;
	}

	public java.awt.Image getLogo() {
		return logo;
	}

	public void setLogo(BufferedImage logo) {
		this.logo = logo;
	}

}
