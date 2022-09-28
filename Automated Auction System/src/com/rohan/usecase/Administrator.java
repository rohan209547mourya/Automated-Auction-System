package com.rohan.usecase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				
				Product pro = new Product();
				
				pro.setId(id);
				pro.setName(n);
				pro.setPrice(p);
				pro.setStatus(s);
				
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seller> viewRegisterdSellers() {
		// TODO Auto-generated method stub
		return null;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
	
}
