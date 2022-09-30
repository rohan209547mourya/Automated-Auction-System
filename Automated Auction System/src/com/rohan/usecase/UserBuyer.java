package com.rohan.usecase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rohan.beans.Buyer;
import com.rohan.beans.Product;
import com.rohan.dao.BuyerDao;
import com.rohan.exception.BuyerException;
import com.rohan.exception.ProductException;
import com.rohan.utility.GetConnection;

public class UserBuyer implements BuyerDao{

	@Override
	public void registerAsBuyer(Buyer user) {
		
		
		try(Connection conn = GetConnection.get()) {
			
			
			PreparedStatement state = conn.prepareStatement("insert into buyers(buyer_name , buyer_username , buyer_password) values (? , ? , ?)");
			
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
	public Buyer loginAsBuyer(String username, String password) {
		
		Buyer user = null;
		
		
		try(Connection conn = GetConnection.get()){
			
			PreparedStatement state = conn.prepareStatement("select * from buyers where buyer_username = ? AND buyer_password = ?");
			
			state.setString(1, username);
			state.setString(2, password);
			
			ResultSet res = state.executeQuery();
			
			if(res.next()) {
				user = new Buyer();
				
				user.setId(res.getInt("buyer_id"));
				user.setName(res.getString("buyer_name"));
				user.setUsername(res.getString("buyer_username"));
				user.setPassword(res.getString("buyer_password"));
				
			}
			else {
				
				throw new BuyerException("user is not registerd or username/password wrong!");
			}
			
		}
		catch(SQLException e) {
			
			System.out.println("ERROR : unable to connect with server");
			
		} 
		catch (BuyerException e) {
			
			System.out.println(e.getMessage());
		}
		
		return user;
	}

	@Override
	public List<Product> viewByCategory(String cate) {
		
		List<Product> products = new ArrayList<>();
		
		try(Connection conn = GetConnection.get()) {
			
			
		    PreparedStatement state = conn.prepareStatement("select * from products where category = ?");
			state.setString(1, cate);
			
			ResultSet res = state.executeQuery();
			
			while(res.next()) {
				
				
				int i = res.getInt("product_id");
				String n = res.getString("product_name");
				int p = res.getInt("base_price");
				String s = res.getString("status");
				String c = res.getString("category");
				
				
				String s1 = "Sold";
				
				if(s.equalsIgnoreCase("N")) {
					
					s1 = "Available";
				}
				
				
				products.add(new Product(i, p, n, s1, c));
				
			}
			
			
			if(products.size() == 0) {
				
				throw new ProductException("Product not available for this category!");
			}
			
		}
		catch(SQLException e) {
			
			System.out.println(e.getMessage());
		} 
		catch (ProductException e) {
			
			System.out.println(e.getMessage());
		}
		
		return products;
	}

	@Override
	public void buyProduct(int product_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> viewAllBuyers() {
		// TODO Auto-generated method stub
		return null;
	}

}
