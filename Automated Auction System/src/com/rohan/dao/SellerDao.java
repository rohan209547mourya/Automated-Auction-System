package com.rohan.dao;

import java.util.List;

import com.rohan.beans.Product;
import com.rohan.beans.Seller;
import com.rohan.exception.SellerException;

public interface SellerDao {


	public void registerAsSeller(Seller user);
	
	public Seller loginAsSeller(String username , String password) throws SellerException;
	
	public void addProducts(List<Product> list);
	
	public List<Product> viewSoldProducts();
	
	public void removeItem(int product_id);
	
	public void addProduct(Product item);
	
	public void updateProduct(int product_id);
}

