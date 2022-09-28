package com.rohan.beans;


public class Product {
	
	private int id;
	private int price;
	private String name;
	private String status;
	
	public Product() {
		
		
	}

	public Product(int id , int price, String name, String status) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + ", name=" + name + ", status=" + status + "]";
	}
	
	
	
}
