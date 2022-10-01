package com.rohan.usecase;

import java.util.Scanner;

public class Main {
	
	static int num = 0;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		
		System.out.println("*****************************************************");
		System.out.println("👉👉👉👉 Welcome to Automated Auction System 👈👈👈👈");
		System.out.println("*****************************************************");
		
		run();
		
	}
	
	
	public static void run() {
		
		System.out.println();
		System.out.println("To Continue as Admin Enter 1 \r\n" 
				+ "To Continue as Buyer Enter 2 \r\n" 
				+ "To Continue as Seller Enter 3 \r\n"
				+ "To Exit Enter 4");
		System.out.println();		
		System.out.print("--------->  ");
		
		
		int input = sc.nextInt();
		
		
		if(input > 4 || input < 1) {
		
		System.out.println("Invalid Input !");
		}
		
		System.out.println("Redirecting to the page!");
		
		x();
		
		System.out.println();
		
		switch (input) {
			case 1 : {
				
				AdminAccess.run();
			}
			break;
			
			case 2 : {
				
				BuyerAccess.run();
			}
			break;
			
			case 3 : {
				
				SellerAccess.run();
			}
			break;
			
			case 4 : {
				
				return;
			}
		}
	}
	
	public static void  x() {
	
		num++;
		
		try {
			
			System.out.print(".");
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		 
		if(num == 3) {
			
			return;
		}
		else {
			
			x();
		}
		
		
	}
	
	
}
