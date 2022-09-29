package com.rohan.usecase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.rohan.beans.Buyer;
import com.rohan.beans.Product;
import com.rohan.dao.BuyerDao;
import com.rohan.exception.BuyerException;
import com.rohan.utility.GetConnection;

public class UserBuyer implements BuyerDao{

	@Override
	public void registerAsBuyer(Buyer user) {
		
		
		
		
		
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
		// TODO Auto-generated method stub
		return null;
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
