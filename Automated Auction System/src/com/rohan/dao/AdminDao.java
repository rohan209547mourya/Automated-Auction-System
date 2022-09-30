package com.rohan.dao;

import java.util.List;
import com.rohan.beans.Admin;
import com.rohan.beans.Buyer;
import com.rohan.beans.Product;
import com.rohan.beans.Seller;

public interface AdminDao {
	
	public Admin adminLogIn(String username , String password);
	
	public List<Product> viewProductsDetails();
	
	public List<Buyer> viewRegisteredBuyers();
	
	public List<Seller> viewRegisterdSellers();
	
}
