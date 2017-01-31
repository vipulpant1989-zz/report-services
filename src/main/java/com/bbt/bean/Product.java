package com.bbt.bean;

public class Product {

	private String name;

	private String description;

	private String address;

	private String id;

	private Double latitude;

	private Double longitude;

	private String rating;

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Product(String product_name, String description, String address,
			String product_id, String rating) {
		super();
		this.name = product_name;
		this.description = description;
		this.address = address;
		this.id = product_id;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String product_name) {
		this.name = product_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String product_id) {
		this.id = product_id;
	}

}
