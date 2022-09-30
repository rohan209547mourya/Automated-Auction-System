package com.rohan.usecase;


public class Run {

	public static void main(String[] args) {
		
		
		UserBuyer b1 = new UserBuyer();
		
		b1.loginAsBuyer("rohan@22", "12345");
		
		b1.buyProduct(4);
		
	}

}
