package com.rohan.usecase;

import java.util.Scanner;

import com.rohan.beans.Buyer;
import com.rohan.daoimpl.UserBuyer;

public class BuyerAccess {
	
	
	static Scanner sc = new Scanner(System.in);
	private static Buyer user;
	private static UserBuyer object;
	
	public static void run() {
		
		
		System.out.println("To register Enter 1 \r\n" 
				+ "To log in Enter 2 \r\n" 
				+ "To view all products by category Enter 3 \r\n"
				+ "To Buy a product Enter 4 \r\n"
				+ "To view all buyers Enter 5 \r\n"
				+ "To Exit Enter 6");
		System.out.println();
		
		System.out.print("---------->  ");
		
		int input =  sc.nextInt();
		
		sc.nextLine();
		
		
		if(input > 6 || input < 1) {
			
			System.out.println("Invalid Input !");
			
			run();
		}
			
		System.out.println();
		
		switch (input) {
		
			case 1 : {
				
				System.out.print("Enter you full name : ");
				String name = sc.nextLine();
				
				System.out.print("Enter you username/email : ");
				
				String username = sc.nextLine();
				
				System.out.print("Set password (Maximum 8 length) : ");
				
				String password = sc.nextLine();
				
				object = new UserBuyer();
				
				Buyer b1 = new Buyer();
				b1.setName(name);
				b1.setUsername(username);
				b1.setPassword(password);
				
				
				object.registerAsBuyer(b1);
				
				
				run1();
			}
			break;
			
			case 2 : {
				
				System.out.println("***********************");
				System.out.print("Enter log in username: ");
				
				String username = sc.nextLine();
				
				System.out.print("Enter log in password: ");
				
				String password = sc.nextLine();
				
				System.out.println("***********************");
				
				object = new UserBuyer();
				
				
				user = object.loginAsBuyer(username, password);
				
				if(user == null) {
					
					run();
					
				}
				else {
					
					run1();
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
				
				if(user == null) {
					
					System.out.println("You have to log in first !");
					
					run();
				}
				
			}
			break;	
			
			case 6 : {
				
				System.out.println("Thank you for using our application ! ");
				
				return;
			}
			
		}
		
	}
	
	
	public static void run1() {
		
		System.out.println("***********************");
		
		System.out.println("To log in Enter 1 \r\n" 
				+ "To view all products by category Enter 2 \r\n"
				+ "To Buy a product Enter 3 \r\n"
				+ "To view all buyers Enter 4 \r\n"
				+ "To log out Enter 5");
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
				System.out.print("Enter log in username: ");
				
				String username = sc.nextLine();
				
				System.out.print("Enter log in password: ");
				
				String password = sc.nextLine();
				
				System.out.println("***********************");
				
				object = new UserBuyer();
				
				
				user = object.loginAsBuyer(username, password);
				
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
					
					run1();
				}
				else {
					
					
					System.out.println("Enter product category to search : ");
					String cate = sc.nextLine();
					
					object.viewByCategory(cate).forEach(s -> {
						
						System.out.println("Product ID       : " + s.getId());
						System.out.println("Product Name     : " + s.getName());
						System.out.println("Product Price    : " + s.getPrice());
						System.out.println("Product Category : " + s.getCategory());
						System.out.println("Product Quantity : " + s.getQuantity());
						System.out.println("Product Status   : " + s.getStatus());	
						
						System.out.println("***********************");
					});				
				
					run1();
				}
			
			}
			break;
			
			case 3 : {
				

				if(user == null) {
					
					System.out.println("You have to log in first !");
					
					run1();
				}
				else {
					
					
					
					System.out.println("Enter product id that you want to buy (For product id you can check the list) : ");
					
					int id = sc.nextInt();
					
					object.buyProduct(id);
					
					
				}
			
				run1();
			}
			break;
			
			case 4 : {
				

				if(user == null) {
					
					System.out.println("You have to log in first !");
					
					run1();
				}
				else {
					
					
					object.viewAllBuyers().forEach(s -> {
						
						
						System.out.println("Buyer ID       : " + s.getId());
						System.out.println("Buyer Name     : " + s.getName());
						System.out.println("Buyer Username : " + s.getUsername());
						
						System.out.println("*************************");
						
					});
					
					run1();
				}
				
				
			}
			break;
			
			case 5 : {
				
				System.out.println("Thank you for using our application ! ");
				
				return;
			}
			
		}
		
	}
}
