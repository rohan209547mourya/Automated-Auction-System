package com.rohan.usecase;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.rohan.beans.Buyer;
import com.rohan.beans.Product;
import com.rohan.dao.BuyerDao;
import com.rohan.exception.BuyerException;
import com.rohan.exception.ProductException;
import com.rohan.utility.GetConnection;

public class UserBuyer implements BuyerDao{

	private Buyer buyer;
	
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
				
				buyer = user;
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
	public void buyProduct(int product_id)  {
		
		try {
			
			if(this.buyer == null) {
			
				throw new BuyerException("You need to login first to buy product!");
			}
		}
		catch (BuyerException e) {
			
			System.out.println(e.getMessage());
		}
		
		
		try(Connection conn = GetConnection.get()){
			
			try (Scanner sc = new Scanner(System.in)) {
				
				System.out.println("Enter quanity: ");
				
				int qun = sc.nextInt();
				sc.nextLine();
				
				PreparedStatement state	= conn.prepareStatement("select * from products where product_id = ?");
				
				state.setInt(1, product_id);
				
				
				ResultSet res = state.executeQuery();
				
				if(res.next()) {
					
					int quantity = res.getInt("quantity");
					
					if(quantity < qun) {
						
						throw new ProductException("Not quantity to buy!");
					}
					else {
						
						System.out.println("Enter delivery address: ");
						
						String add = sc.nextLine();
						
						if(quantity == qun) {
							
							PreparedStatement getId = conn.prepareStatement("select seller_id from products_seller where product_id = ?");
							getId.setInt(1, product_id);
							
							ResultSet res1 = getId.executeQuery();
							
							if(res1.next()) {
								
								 int id = res1.getInt("seller_id");
								 
								 PreparedStatement insertIntoSales = conn.prepareStatement("insert into dailysales values(? , ? , ?)");
									
									
								insertIntoSales.setInt(1, id);
								
								LocalDate date = LocalDate.now();
								
								insertIntoSales.setDate(2, Date.valueOf(date));
								insertIntoSales.setInt(3, (res.getInt("base_price") * qun));
								
								int k = insertIntoSales.executeUpdate();
								
								
								PreparedStatement update = conn.prepareStatement("delete from products where product_id = ? AND quantity = ?");
								
								PreparedStatement relDelete =  conn.prepareStatement("delete from products_seller where product_id = ?");
								
								update.setInt(1, product_id);
								update.setInt(2, qun);
								relDelete.setInt(1, product_id);
								
								int k1 = relDelete.executeUpdate(); 
								int n = update.executeUpdate();
								
								if(n > 0) {
									
									System.out.println("Order Placed succesfully!");
								}
								else {
									
									throw new ProductException("Unable to place order!");
								}
							}
						}
						else {
							
							
							PreparedStatement getId = conn.prepareStatement("select seller_id from products_seller where product_id = ?");
							getId.setInt(1, product_id);
							
							ResultSet s = getId.executeQuery();
							
							if(s.next()) {
							
								int id = s.getInt("seller_id");
								
								PreparedStatement insertIntoSales = conn.prepareStatement("insert into dailysales values( ? , ? , ?)");
								
								insertIntoSales.setInt(1, id);
								
								LocalDate date = LocalDate.now();
								
								insertIntoSales.setDate(2, Date.valueOf(date));
								insertIntoSales.setInt(3, (res.getInt("base_price") * qun));
								
								insertIntoSales.executeUpdate();
								
								
								PreparedStatement update = conn.prepareStatement("update products set quantity = quantity - ? where product_id = ?");
								
								update.setInt(1, qun); 
								update.setInt(2, product_id);
								
								int n = update.executeUpdate();
								
								
								if(n > 0 ) {
									
									System.out.println("Order placed!");
								}
								else {
									
									throw new ProductException("unable to place order!");
								}
							}
							
						}
					}
					
					
				}
				else {
					
					throw new ProductException("There is no product with this id!");
				}
			}
			
		}
		catch(SQLException e) {
			
			System.out.println(e.getMessage());
		} 
		catch (ProductException e) {

			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public List<Buyer> viewAllBuyers() {
		
		
		List<Buyer> buyers = new ArrayList<>();
		
		
		try(Connection conn = GetConnection.get()) {
			
			PreparedStatement state = conn.prepareStatement("select * from buyers");
			
			ResultSet res = state.executeQuery();
			
			boolean flag = false;
			
			while(res.next()) {
				
				flag = true;
				
				buyers.add(new Buyer(res.getInt("buyer_id"), res.getString("buyer_name"), res.getString("buyer_username"), res.getString("buyer_password")));
				
			}
			
			if(!flag) {
				
				throw new BuyerException("There is not buyer registerd!");
			}
			
		} 
		catch (SQLException e) {
			
			System.out.println(e.getMessage());
		} 
		catch (BuyerException e) {
			
			System.out.println(e.getMessage());
		}
		
		return buyers;
	}

}
