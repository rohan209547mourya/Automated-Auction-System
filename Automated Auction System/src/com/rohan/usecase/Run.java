package com.rohan.usecase;

import java.util.List;

import com.rohan.beans.Admin;
import com.rohan.beans.Product;

public class Run {

	public static void main(String[] args) {
		

		Administrator obj = new Administrator();
		
		Admin a = obj.adminLogIn("admin", "rootrm");
		
		try {
		
			List<Product> pros = obj.viewProductsDetails();
			
			for(Product el : pros) {
				
				System.out.println(el);
			}
			
		}
		catch (NullPointerException e) {
			
			
		}
	}

}
