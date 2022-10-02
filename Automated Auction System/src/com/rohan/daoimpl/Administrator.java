package com.rohan.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.rohan.beans.Admin;
import com.rohan.beans.Buyer;
import com.rohan.beans.Product;
import com.rohan.beans.Seller;
import com.rohan.dao.AdminDao;
import com.rohan.utility.GetConnection;

public class Administrator implements AdminDao{
	
	private Admin admin;
	
	@Override
	public Admin adminLogIn(String username , String password) {
		
		Admin user = null;
		
		try(Connection conn = GetConnection.get()){
				
			PreparedStatement state = conn.prepareStatement("select * from admin where Admin_username = ? AND Admin_password = ?");
			
			
			state.setString(1, username);
			state.setString(2, password);
			
			
			ResultSet res = state.executeQuery();
			
			
			if(res.next()) {
				
				user = new Admin(true,res.getInt("Admin_id"), res.getString("Admin_name"), res.getString("Admin_username"), res.getString("Admin_password"));
				this.admin = user;
				
				System.out.println("Log in successfully !" );
			}
			else {
				
				System.out.println("unable to log in please try again!");
			}
			
			
		}
		catch(NullPointerException e) {
			
			
		}
		catch(SQLException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		return user;
			
	}

	@Override
	public List<Product> viewProductsDetails() {
		
		
		
		if(this.admin == null) {
			
			System.out.println("To access this functionality you need to login first!");
			
			return null;
		}
		
		
		List<Product> products = new ArrayList<>();
		
		try(Connection conn = GetConnection.get()) {
			
			PreparedStatement state = conn.prepareStatement("select * from products");	
			
			ResultSet res = state.executeQuery();
			
			
			
			while(res.next()) {
				
				
				int id = res.getInt("product_id");
				String n = res.getString("product_name");
				int p = res.getInt("base_price");
				String s = res.getString("status");
				int  q = res.getInt("quantity");
				String c = res.getString("category");
				Product pro = new Product();
				
				pro.setId(id);
				pro.setName(n);
				pro.setPrice(p);
				pro.setStatus(s);
				pro.setQuantity(q);
				pro.setCategory(c);
				
				
				products.add(pro);
			}
			
			
			if(products.size() == 0) {
				
				System.out.println("There is no product for sale!");
			}
			
		}
		catch(SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		
		
		
		return products;
	}

	@Override
	public List<Buyer> viewRegisteredBuyers() {
		
		if(this.admin == null) {
			
			System.out.println("To access this functionality you need to login first!");
			
			return null;
		}
		
		
		List<Buyer> users = new ArrayList<>();
		
		try(Connection conn = GetConnection.get()) {
			
			PreparedStatement state = conn.prepareStatement("select * from buyers");	
			
			ResultSet res = state.executeQuery();
			
			
			
			while(res.next()) {
				
				
				int id = res.getInt("buyer_id");
				String n = res.getString("buyer_name");
				String s = res.getString("buyer_username");
				String p = res.getString("buyer_password");
				
				users.add(new Buyer(id, n, s, p));				
			}
			
			
			if(users.size() == 0) {
				
				System.out.println("There is no registerd buyer!");
			}
			
		}
		catch(SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		
		
		
		return users;
	}

	@Override
	public List<Seller> viewRegisterdSellers() {
		
		if(this.admin == null) {
			
			System.out.println("To access this functionality you need to login first!");
			
			return null;
		}
		
		
		List<Seller> users = new ArrayList<>();
		
		try(Connection conn = GetConnection.get()) {
			
			PreparedStatement state = conn.prepareStatement("select * from seller");	
			
			ResultSet res = state.executeQuery();
			
			
			
			while(res.next()) {
				
				
				int id = res.getInt("seller_id");
				String n = res.getString("seller_name");
				String s = res.getString("seller_username");
				String p = res.getString("seller_password");
				
				users.add(new Seller(id, n, s, p));				
			}
			
			
			if(users.size() == 0) {
				
				System.out.println("There is no registerd Seller!");
			}
			
		}
		catch(SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		
		
		
		return users;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public void viewDailyTotalSales() {
		
		if(this.admin == null) {
			
			System.out.println("To access this functionality you need to login first!");
			
			return ;
		}
		
		
		
		try(Connection conn = GetConnection.get()) {
			
			
			
			PreparedStatement state =  conn.prepareStatement("select * from dailysales where sale_date = ?");
			

			LocalDate date = LocalDate.now();
			
			state.setDate(1, Date.valueOf(date));
			
			
			int total = 0;
			
			ResultSet res = state.executeQuery();
			
			
			
			
			while(res.next() ) {
				
				total += res.getInt("total_sales");
			}
			
			
			System.out.println("Total Sale of Today is : "  + total);
			
		}
		catch(SQLException e) {
			
			
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	
}
