package com.example.jsonstudy.data;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Data {

	public static String ORDER_JSON_STRING = "{" + "\"orderId\": 1," + "\"customerName\": \"John Doe\","
			+ "\"tax\": 8.5," + "\"subTotal\": 50.00," + "\"total\": 54.25," + "\"isPaid\": true,"
			+ "\"orderDate\": \"2023-01-15\"," + "\"items\": [\"Laptop\", \"Mouse\", \"Keyboard\"],"
			+ "\"itemQuantities\": {\"Laptop\": 1, \"Mouse\": 2, \"Keyboard\": 1}" + "}";

	public static String ORDER_LIST_JSON_STRING = "[{" + "\"orderId\": 1," + "\"customerName\": \"John Doe\","
			+ "\"tax\": 8.5," + "\"subTotal\": 50.00," + "\"total\": 54.25," + "\"isPaid\": true,"
			+ "\"orderDate\": \"2023-01-15\"," + "\"items\": [\"Laptop\", \"Mouse\", \"Keyboard\"],"
			+ "\"itemQuantities\": {\"Laptop\": 1, \"Mouse\": 2, \"Keyboard\": 1}" + "}]";

	public static Order ORDER_OBJECT() {
		Order order1 = new Order();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			order1.setOrderId(1);
			order1.setCustomerName("John Doe");
			order1.setTax(8.5);
			order1.setSubTotal(new BigDecimal(50.00));
			order1.setTotal(new BigDecimal(54.25));
			order1.setIsPaid(true);
			order1.setOrderDate(sdf.parse("2023-01-15"));
			order1.setItems(Arrays.asList("Laptop", "Mouse", "Keyboard"));
			order1.setItemQuantities(Map.of("Laptop", 1, "Mouse", 2, "Keyboard", 1));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return order1;
	}

	public static List<Order> ORDER_LIST_OBJECT() {
		List<Order> orders = new ArrayList<>();

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			Order order1 = new Order();
			order1.setOrderId(1);
			order1.setCustomerName("John Doe");
			order1.setTax(8.5);
			order1.setSubTotal(new BigDecimal(50.00));
			order1.setTotal(new BigDecimal(54.25));
			order1.setIsPaid(true);
			order1.setOrderDate(sdf.parse("2023-01-15"));
			order1.setItems(Arrays.asList("Laptop", "Mouse", "Keyboard"));
			order1.setItemQuantities(Map.of("Laptop", 1, "Mouse", 2, "Keyboard", 1));

			Order order2 = new Order();
			order2.setOrderId(2);
			order2.setCustomerName("Jane Smith");
			order2.setTax(7.0);
			order2.setSubTotal(new BigDecimal(75.50));
			order2.setTotal(new BigDecimal(80.79));
			order2.setIsPaid(false);
			order2.setOrderDate(sdf.parse("2023-02-20"));
			order2.setItems(Arrays.asList("Headphones", "Phone Case"));
			order2.setItemQuantities(Map.of("Headphones", 1, "Phone Case", 3));

			orders.addAll(Arrays.asList(order1, order2));

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return orders;
	}

}
