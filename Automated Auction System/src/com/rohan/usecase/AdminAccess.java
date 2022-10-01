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
				+ "To log out 4");
		System.out.println("***********************");
		System.out.println();
		
		System.out.print("---------->  ");
		
		int input =  sc.nextInt();
		
		sc.nextLine();
		
		
		if(input > 4 || input < 1) {
			
			System.out.println("Invalid Input !");
		}
			
		System.out.println();
		
		switch (input) {
			case 1 : {
				
				object.viewProductsDetails().forEach( s -> {
					
					System.out.println("Product id = " + s.getId());
					System.out.println("Product name = " + s.getName());
					System.out.println("Product price = " + s.getPrice());
					System.out.println("Product quantity = " + s.getQuantity());
					System.out.println("Product status = " + s.getStatus());
					System.out.println("Product category = " + s.getCategory());
					
					System.out.println("*************************");
				});
				
				run1();
			}
			break;
			
			case 2 : {
				
				
				object.viewRegisteredBuyers().forEach(s -> {
					
					
					System.out.println("Buyer id = " + s.getId());
					System.out.println("Buyer name = " + s.getName());
					System.out.println("Buyer username = " + s.getUsername());
					System.out.println("Buyer password = " + s.getPassword());
					
					System.out.println("*************************");
					
				});
				
				run1();
			}
			break;
			
			case 3 : {
				
				object.viewRegisterdSellers().forEach(s -> {
					
					
					System.out.println("Seller id = " + s.getId());
					System.out.println("Selller name = " + s.getName());
					System.out.println("Seller username = " + s.getUsername());
					System.out.println("Seller password = " + s.getPassword());
					
					System.out.println("******************************************");
					
				});
				
				run1();
				
				
			}
			break;
			
			case 4 : {
				
				System.out.println("Thank you for using our application ! ");
				
				return;
				
			}
			
		}
	}
	
	
	
	
	
}
