package com.rohan.usecase;

import java.util.Scanner;

import com.rohan.beans.Admin;
import com.rohan.daoimpl.Administrator;

public class AdminAccess {
	
	static Scanner sc = new Scanner(System.in);
	private static Admin user;
	private static Administrator object;
	
	public static void run() {
			
		System.out.println("To log in with username password Enter 1 \r\n" 
				+ "To view all products details Enter 2 \r\n" 
				+ "To view all registered buyers Enter 3 \r\n"
				+ "To view all registered Sellers Enter 4 \r\n"
				+ "To Exit Enter 5");
		System.out.println();
		
		System.out.print("---------->  ");
		
		int input =  sc.nextInt();
		
		sc.nextLine();
		
		
		if(input > 5 || input < 1) {
			
			System.out.println("Invalid Input !");
		}
			
		System.out.println();
		
		switch (input) {
			case 1 : {
				
				System.out.println("***********************");
				System.out.print("Enter Admin username: ");
				
				String username = sc.nextLine();
				
				System.out.print("Enter Admin password: ");
				
				String password = sc.nextLine();
				
				System.out.println("***********************");
				
				object = new Administrator();
				
				
				user = object.adminLogIn(username, password);
				
				if(user == null) {
					
					run();
					
				}
				else {
					
					run1();
				}
				
				
			}
			break;
			
			case 2 : {
				
				
				if(user == null) {
					
					System.out.println("You have to log in first !");
					
					run();
				}		
				
			}
			break;
			
			case 3 : {
				
				if(user == null) {
					
					System.out.println("You have to log in first !");
					
					run();
				}
				
			}
			break;
			
			case 4 : {
				
				if(user == null) {
					
					System.out.println("You have to log in first !");
					
					run();
				}
				
			}
			break;
			
			case 5 : {
				
				System.out.println("Thank you for using our application ! ");
				
				return;
			}
			
		}
	}
	
	
	
	public static void run1() {
		
		System.out.println("To view all products details Enter 1 \r\n" 
				+ "To view all registered buyers Enter 2 \r\n"
				+ "To view all registered Sellers Enter 3 \r\n"
				+ "To check daily total sales Enter 4 \r\n"
				+ "To log out 5");
		System.out.println("***********************");
		System.out.println();
		
		System.out.print("---------->  ");
		
		int input =  sc.nextInt();
		
		sc.nextLine();
		
		
		if(input > 5 || input < 1) {
			
			System.out.println("Invalid Input !");
		}
			
		System.out.println();
		
		switch (input) {
			case 1 : {
				
				object.viewProductsDetails().forEach( s -> {
					
					System.out.println("Product ID       : " + s.getId());
					System.out.println("Product Name     : " + s.getName());
					System.out.println("Product Price    : " + s.getPrice());
					System.out.println("Product Category : " + s.getCategory());
					System.out.println("Product Quantity : " + s.getQuantity());
					System.out.println("Product Status   : " + s.getStatus());	
					
					System.out.println("*************************");
				});
				
				run1();
			}
			break;
			
			case 2 : {
				
				
				object.viewRegisteredBuyers().forEach(s -> {
					
					
					System.out.println("Buyer ID       : " + s.getId());
					System.out.println("Buyer Name     : " + s.getName());
					System.out.println("Buyer Username : " + s.getUsername());
					System.out.println("Buyer Password : " + s.getPassword());
					
					System.out.println("*************************");
					
				});
				
				run1();
			}
			break;
			
			case 3 : {
				
				object.viewRegisterdSellers().forEach(s -> {
					
					
					System.out.println("Seller ID       : " + s.getId());
					System.out.println("Selller Name    : " + s.getName());
					System.out.println("Seller Username : " + s.getUsername());
					System.out.println("Seller Password : " + s.getPassword());
					
					System.out.println("******************************************");
					
				});
				
				run1();
				
				
			}
			break;
			
			
			case 4 : {
				
				object.viewDailyTotalSales();
				
				run1();
			}
			break;
			
			case 5 : {
				
				System.out.println("Thank you for using our application ! ");
				
				return;
				
			}

		}
	}
	
	
	
	
	
}
