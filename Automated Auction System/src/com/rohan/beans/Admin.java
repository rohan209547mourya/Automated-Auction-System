package com.rohan.beans;

public class Admin {
	
	private int id;
	private boolean login;
	private String name;
	private String username;
	private String password;
	
	
	public Admin() {
		
		
	}
	
	
	public Admin(boolean log, int id, String name, String username, String password) {
		super();
		this.login = log;
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public boolean isLogin() {
		return login;
	}


	public void setLogin(boolean login) {
		this.login = login;
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
		return "Admin [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	
	
	
}
