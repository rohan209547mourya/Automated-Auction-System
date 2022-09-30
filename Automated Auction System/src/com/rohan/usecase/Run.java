package com.rohan.usecase;

public class Run {

	public static void main(String[] args) {
		
		
		UserBuyer b1 = new UserBuyer();
		
		b1.viewAllBuyers().forEach(s -> System.out.println(s));
		
	}

}
