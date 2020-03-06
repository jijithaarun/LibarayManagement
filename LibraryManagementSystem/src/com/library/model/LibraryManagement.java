package com.library.model;

import java.util.Date;

public class LibraryManagement {
	
	//insatnce variable
	private Integer isbnNo;
	private String bookTitle;
	private String authorName;
	private Integer quantity;
	private Date purchaseDate;
	private String edition;
	private Integer price;
	private Integer noOfpages;
	private String purchaserName;
	private String purchaserAddress;
	private String emailId;
	private String phone;
	private Boolean isActive;
	
	//default constructor
	public LibraryManagement() {
		super();
		
	}

	public Integer getIsbnNo() {
		return isbnNo;
	}

	public void setIsbnNo(Integer isbnNo) {
		this.isbnNo = isbnNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getNoOfpages() {
		return noOfpages;
	}

	public void setNoOfpages(Integer noOfpages) {
		this.noOfpages = noOfpages;
	}

	public String getPurchaserName() {
		return purchaserName;
	}

	public void setPurchaserName(String purchaserName) {
		this.purchaserName = purchaserName;
	}

	public String getPurchaserAddress() {
		return purchaserAddress;
	}

	public void setPurchaserAddress(String purchaserAddress) {
		this.purchaserAddress = purchaserAddress;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	

	

}
