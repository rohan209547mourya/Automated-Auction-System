package com.rohan.usecase;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.rohan.beans.Product;
import com.rohan.beans.Seller;
import com.rohan.daoimpl.UserSeller;


public class SellerAccess {
	
	
	private static Seller user;
	private static UserSeller object;
	static Scanner sc = new Scanner(System.in);
	private static List<Product> list = new ArrayList<>();
	
	
	public static void run() {
		
		System.out.println("To register as seller Enter 1 \r\n" 
							+ "To log in with username/password Enter 2 \r\n"
							+ "To add Multiple Products Enter 3 \r\n"
							+ "To add Single Product Enter 4 \r\n"
							+ "To Remove product Enter 5 \r\n"
							+ "To Update product details Enter 6 \r\n"
							+ "To View Sold Products Enter 7 \r\n"
							+ "To Exit Enter 8 \r\n");
		System.out.println();
		System.out.println("********************************************");
		
		System.out.print("------>  ");
		int input = sc.nextInt();
		
		
		sc.nextLine();
		
		if(input > 8 || input < 1) {
			
			System.out.println("Invalid input !");
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
				
				object = new UserSeller();
				
				Seller b1 = new Seller();
				b1.setName(name);
				b1.setUsername(username);
				b1.setPassword(password);
				
				
				object.registerAsSeller(b1);
				
				
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
				
				object = new UserSeller();
				
				
				user = object.loginAsSeller(username, password);
				
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
				
				if(user == null) {
					
					System.out.println("You have to log in first !");
					
					run();
				}
				
			}
			break;
			
			
			case 7 : {
				
				if(user == null) {
					
					System.out.println("You have to log in first !");
					
					run();
				}
			
			}
			break;
			
			case 8 : {
				
				System.out.println("Thank you for using our application ! ");
				
				return;
			}
			
			
		}
	}
	
	
	public static void run1() {
		
		System.out.println("********************************************");
		System.out.println("To log in with username/password Enter 1 \r\n"
				+ "To add Multiple Products Enter 2 \r\n"
				+ "To add Single Product Enter 3 \r\n"
				+ "To Remove product Enter 4 \r\n"
				+ "To Update product details Enter 5 \r\n"
				+ "To View Sold Products Enter 6 \r\n"
				+ "To Log out Enter 7 \r\n");
		System.out.println();
		System.out.println("********************************************");
		
		System.out.print("------>  ");
		int input = sc.nextInt();
		
		
		sc.nextLine();
		
		if(input > 7 || input < 1) {
		
		System.out.println("Invalid input !");
		run();
		
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
				
				object = new UserSeller();
				
				
				user = object.loginAsSeller(username, password);
				
				run1();
				
			}
			break;
			
			case 2 : {
				
				if(user == null) {
					
					System.out.println("You have to log in first !");
					
					run1();
				}
				else {
				
					addToList();
				}
			}
			break;
			
			case 3 : {
				
				if(user == null) {
					
					System.out.println("You have to log in first !");
					
					run1();
				}
				else {
					
					
					
					System.out.println("Enter product Name : ");
					
					
					String name = sc.nextLine();
					

					System.out.println("Enter product category : ");
					
					String cate = sc.nextLine(); 
			
					
					System.out.println("Enter product quantity : ");
					
					int qun = sc.nextInt();
					
					System.out.println("Enter product price : ");
					
					int price = sc.nextInt();
					
					
					Product temp = new Product();
					
					
					temp.setName(name);
					temp.setCategory(cate);
					temp.setPrice(price);
					temp.setQuantity(qun);
					
					
					
					object.addProduct(temp);
					
					run1();
				}
				
			}
			break;
			
			case 4 : {
				
				if(user == null) {
					
					System.out.println("You have to log in first !");
					
					run1();
				}
				else {
					
					
					
					removeItem();
					
				}
				
			}
			break;
			
			case 5 : {
				
				if(user == null) {
					
					System.out.println("You have to log in first !");
					
					run1();
				}
				else {
					
					
					updateItem();
					
				}
				
			}
			break;	
			
			case 6 : {
				
				if(user == null) {
					
					System.out.println("You have to log in first !");
					
					run1();
				}
				else {
					
					
					
					object.viewSoldProducts().forEach(s -> {
						
						
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
			
			
			case 7 : {
				
				System.out.println("Thank you for using our application ! ");
				
				return;
			
			}		
			
		}
		
		
	}
	
	
	
	
	
	public static void addToList() {
		
		System.out.println("To add products to list Enter 1 \r\n"
				+ "To add product list to store Enter 2 \r\n"
				+ "To Exit Enter 3");
		System.out.println("************************");
		System.out.println("------->  ");
		int input1= sc.nextInt();
		
		sc.nextLine();
		
		if(input1 == 1) {
			
			
			System.out.println("Enter product Name : ");
			
			
			String name = sc.nextLine();
			

			System.out.println("Enter product category : ");
			
			String cate = sc.nextLine(); 
	
			
			System.out.println("Enter product quantity : ");
			
			int qun = sc.nextInt();
			
			System.out.println("Enter product price : ");
			
			int price = sc.nextInt();
			
			
			Product temp = new Product();
			
			
			temp.setName(name);
			temp.setCategory(cate);
			temp.setPrice(price);
			temp.setQuantity(qun);
			
			list.add(temp);
			
			addToList();
		}
		else if(input1 == 2) {
		
		
			if(list.size() == 0) {
				
				System.out.println("No product to add ! ");
			}
			else {
				
				object.addProducts(list);
				
				list = new ArrayList<>();
				
			}
			
			run1();
		}
		else if(input1 == 3){
		
			
			run1();
		}
		else {
		
		
			System.out.println("Invalid input !");
			
			addToList();
		}
	}
	
	
	
	
	public static void removeItem() {
		
		
		System.out.println("Enter product id to remove product (If you don't know product id Enter 0) : ");
		
		int input = sc.nextInt();
		
		if(input == 0) {
			
			object.viewAllProdcuts().forEach(s -> {
				
				
				System.out.println("Product ID       : " + s.getId());
				System.out.println("Product Name     : " + s.getName());
				System.out.println("Product Price    : " + s.getPrice());
				System.out.println("Product Category : " + s.getCategory());
				System.out.println("Product Quantity : " + s.getQuantity());
				System.out.println("Product Status   : " + s.getStatus());	
				
				System.out.println("***********************");	
		
			});
			
			removeItem();
		}
		else {
			
			
			object.removeItem(input);
			
			run1();
			
		}
		
	}
	
	
	
	
	public static void updateItem() {
		
		
		System.out.println("Enter product id to update product details (If you don't know product id Enter 0) : ");
		
		int input = sc.nextInt();
		
		if(input == 0) {
			
			object.viewAllProdcuts().forEach(s -> {
				
				
				System.out.println("Product ID       : " + s.getId());
				System.out.println("Product Name     : " + s.getName());
				System.out.println("Product Price    : " + s.getPrice());
				System.out.println("Product Category : " + s.getCategory());
				System.out.println("Product Quantity : " + s.getQuantity());
				System.out.println("Product Status   : " + s.getStatus());	
				
				System.out.println("***********************");	
		
			});
			
			updateItem();
		}
		else {
			
			
			object.performUpdate(input);
			
			run1();
			
		}
		
	}
	
	
	
}
