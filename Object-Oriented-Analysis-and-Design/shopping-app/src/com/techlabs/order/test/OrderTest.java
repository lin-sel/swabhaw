package com.techlabs.order.test;

import com.techlabs.lineitem.LineItem;
import com.techlabs.order.Order;
import com.techlabs.product.Product;

public class OrderTest {

	public static void main(String[] args) {
		Product product1 = new Product(101,"Dell Laptop",35000,10);
		Product product2 = new Product(102,"Asus Laptop",45000,5);
		Product product3 = new Product(101,"Dell Laptop",35000,10);
		
		LineItem lineitem1 = new LineItem(201,product1, 2);
		LineItem lineitem2 = new LineItem(202,product2, 3);
		LineItem lineitem3 = new LineItem(202,product3, 1);
		
		Order order = new Order(404,"26/11/2019");
		order.addItem(lineitem1);
		order.addItem(lineitem3);
		
		System.out.println(order.getItemlist().size());
		System.out.println(order.getItemlist().get(0).getQuantity());
		
	}

}
