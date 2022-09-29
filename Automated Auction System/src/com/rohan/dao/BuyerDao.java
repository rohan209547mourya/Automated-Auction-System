package com.rohan.dao;

import java.util.List;

import com.rohan.beans.Buyer;
import com.rohan.beans.Product;
import com.rohan.exception.BuyerException;

public interface BuyerDao {
	
	public void registerAsBuyer(Buyer user);
	
	public Buyer loginAsBuyer(String username , String password) throws BuyerException;
	
	public List<Product> viewByCategory(String cate);
	
	public void buyProduct(int product_id);
	
	public List<String> viewAllBuyers();
}
