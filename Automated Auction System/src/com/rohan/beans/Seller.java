package com.rohan.beans;

public class Seller {
	
	private int id;
	private String name;
	private String username;
	private String password;
	
	public Seller() {
		super();
	}

	public Seller( String name, String username, String password) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Seller [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	
	
	
	
	
}
