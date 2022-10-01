package com.rohan.beans;


public class Product {
	
	private int id;
	private int price;
	private String name;
	private String status;
	private String category;
	private int quantity;
	
	
	public Product(int id, int price, int qun, String name, String status, String category) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
		this.status = status;
		this.category = category;
		this.quantity = qun;
	}

	public Product() {
		
		
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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
		return "Product [id=" + id + ", price=" + price + ", name=" + name + ", status=" + status + ", category="
				+ category + ", quantity=" + quantity + "]";
	}

	
	
	
	
	
}
