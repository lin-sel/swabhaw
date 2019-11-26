package com.techlabs.customer.test;

import java.util.List;

import com.techlabs.customer.Customer;
import com.techlabs.lineitem.LineItem;
import com.techlabs.order.Order;
import com.techlabs.product.Product;

public class CustomerTest {

	public static void main(String[] args) {
		Product product1 = new Product(101,"Dell Laptop",35000,10);
		Product product2 = new Product(102,"Asus Laptop",45000,5);
		Product product3 = new Product(105,"Asus Rog",35000,20);
		
		LineItem lineitem1 = new LineItem(201,product1, 2);
		LineItem lineitem2 = new LineItem(202,product2, 3);
		LineItem lineitem3 = new LineItem(203,product3, 2);
		
		Order order = new Order(404,"26/11/2019");
		order.addItem(lineitem1);
		order.addItem(lineitem2);
		order.addItem(lineitem3);
		
		Customer customer = new Customer(901,"ABC");
		customer.addItem(order);
		printInfo(customer);
	}

	private static void printInfo(Customer customer) {
		List<Order> orderitem = customer.getOrder();
		for(Order order : orderitem) {
			System.out.println("Order ID : "+order.getId());
			List<LineItem> itemlist = order.getItemlist();
			printOrderItemInfo(itemlist);
		}
	}

	private static void printOrderItemInfo(List<LineItem> itemlist) {
		for(LineItem item : itemlist) {
			printProductInfo(item);
			System.out.println("Total Cost for "+item.getId() +": "+item.calculateItemCost());
		}
	}

	private static void printProductInfo(LineItem item) {
		System.out.println("Item ID: "+item.getId());
		System.out.println("Product ID: "+item.getProduct().getId());
		System.out.println("Product Name: "+item.getProduct().getName());
		System.out.println("Product Dis: "+item.getProduct().getDiscount());
		System.out.println("Product Cost: "+item.getProduct().getCost());
	}

}
