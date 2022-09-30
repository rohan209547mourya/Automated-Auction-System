package com.rohan.usecase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.rohan.beans.Product;
import com.rohan.beans.Seller;
import com.rohan.dao.SellerDao;
import com.rohan.exception.BuyerException;
import com.rohan.exception.SellerException;
import com.rohan.utility.GetConnection;

public class UserSeller implements SellerDao{

	private Seller user;
	
	@Override
	public void registerAsSeller(Seller user) {
		
		try(Connection conn = GetConnection.get()) {
			
			
			PreparedStatement state = conn.prepareStatement("insert into seller(seller_name , seller_username , seller_password) values (? , ? , ?)");
			
			state.setString(1, user.getName());
			state.setString(2, user.getUsername());
			state.setString(3, user.getPassword());
			
			if(state.executeUpdate() > 0) {
				
				System.out.println("User registered successfully!");
			}
			else {
				
				throw new BuyerException("User already registered!");
			}		
			
		}
		catch(SQLException e) {
			
			System.out.println(e.getMessage());
			
		} 
		catch (BuyerException e) {
			
			System.out.println(e.getMessage());
		}
		
		
	}

	@Override
	public Seller loginAsSeller(String username, String password) throws SellerException {
		
		Seller sell = null;
		
		try(Connection conn = GetConnection.get()){
			
			PreparedStatement state = conn.prepareStatement("select * from seller where seller_username = ? AND seller_password = ?");
			
			state.setString(1, username);
			state.setString(2, password);
			
			ResultSet res = state.executeQuery();
			
			if(res.next()) {
				sell = new Seller();
				
				sell.setId(res.getInt("buyer_id"));
				sell.setName(res.getString("buyer_name"));
				sell.setUsername(res.getString("buyer_username"));
				sell.setPassword(res.getString("buyer_password"));
				
				this.setUser(sell);
			}
			else {
				
				throw new SellerException("user is not registerd or username/password wrong!");
			}
			
		}
		catch(SQLException e) {
			
			System.out.println("ERROR : unable to connect with server");
			
		} 
		catch (SellerException e) {
			
			System.out.println(e.getMessage());
		}
		
		return sell;
	}

	@Override
	public List<Product> viewSoldProducts()  {
		
		try {
			
			if(this.user == null ) {
				
				
				throw new SellerException("you need to log in first to access this!");
				
			}
		}
		catch (SellerException e) {

			System.out.println(e.getMessage());
		}
		
		
		
		List<Product> list = new ArrayList<>();
		
		
		try(Connection conn = GetConnection.get()){
			
			
			PreparedStatement state = conn.prepareStatement("select * from products p INNER JOIN products_seller k where k.seller_id = ? AND p.product_id = k.product_id");
			
			state.setInt(1, this.user.getId());
			
			ResultSet res = state.executeQuery();			
			
			
			boolean flag = false;
			
			
			while(res.next()) {
				
				flag = true;
				
				Product p = new Product(res.getInt("product_id"), res.getInt("base_price"), res.getString("product_name"), res.getString("status"), res.getString("category"));
				
				list.add(p);
				
			}
			
			if(!flag) {
				
				System.out.println("There is no product sold!");
			}
			
		}
		catch(SQLException e) {
			
			
			System.out.println(e.getMessage());
		}
		
		
		
		
		return list;
	}

	@Override
	public void removeItem(int product_id) {
		
		try {
			
			if(this.user == null ) {
				
				
				throw new SellerException("you need to log in first to access this!");
				
			}
		}
		catch (SellerException e) {

			System.out.println(e.getMessage());
		}		
		
		
		try(Connection conn = GetConnection.get()) {
			
			
			PreparedStatement del = conn.prepareStatement("delete from products_seller where product_id = ?");
			PreparedStatement state = conn.prepareStatement("delete from products where product_id = ?");
			
			del.setInt(1, product_id);
			state.setInt(1, product_id);
			
			del.executeUpdate();
			if(!(state.executeUpdate() > 0)) {
				
				System.out.println("Unable to delete the product");
			}
				
		}
		catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
	
	@Override
	public void addProducts(List<Product> list) {
		
		try {
			
			if(this.user == null ) {
				
				
				throw new SellerException("you need to log in first to access this!");
				
			}
		}
		catch (SellerException e) {

			System.out.println(e.getMessage());
		}
	}

	@Override
	public void addProduct(Product item) {
		
		try {
			
			if(this.user == null ) {
				
				
				throw new SellerException("you need to log in first to access this!");
				
			}
		}
		catch (SellerException e) {

			System.out.println(e.getMessage());
		}
	}

	@Override
	public void updateProduct(int product_id) {
		
		try {
			
			if(this.user == null ) {
				
				
				throw new SellerException("you need to log in first to access this!");
				
			}
		}
		catch (SellerException e) {

			System.out.println(e.getMessage());
		}
		
	
		Scanner sc = new Scanner(System.in);
		
		
		
	}
	
	
	
	
	

	public Seller getUser() {
		return user;
	}

	public void setUser(Seller user) {
		this.user = user;
	}
	
	
	
}
