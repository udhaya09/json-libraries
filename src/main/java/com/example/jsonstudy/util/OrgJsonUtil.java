package com.example.jsonstudy.util;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.jsonstudy.data.Data;
import com.example.jsonstudy.data.Order;

public class OrgJsonUtil implements JsonUtil {

	@Override
	public String convertToJsonString(List<Order> orders) throws Exception {
		JSONArray jsonArray = new JSONArray(orders);
		return jsonArray.toString();
	}

	@Override
	public String convertToJsonString(Order order) throws Exception {
		JSONObject jsonObject = new JSONObject(order);
		return jsonObject.toString();
	}

	@Override
	public Order convertToObject(String json) throws Exception {
		JSONObject jsonObject = new JSONObject(json);

		int orderId = jsonObject.getInt("orderId");
		String customerName = jsonObject.getString("customerName");
		double tax = jsonObject.getDouble("tax");
		BigDecimal subTotal = new BigDecimal(jsonObject.getDouble("subTotal"));
		BigDecimal total = new BigDecimal(jsonObject.getDouble("total"));
		boolean isPaid = jsonObject.getBoolean("isPaid");
		Date orderDate = new SimpleDateFormat("yyyy-MM-dd").parse(jsonObject.getString("orderDate"));

		List<String> items = new ArrayList<>();
		JSONArray itemsArray = jsonObject.getJSONArray("items");
		for (int i = 0; i < itemsArray.length(); i++) {
			items.add(itemsArray.getString(i));
		}

		Map<String, Integer> itemQuantities = new HashMap<>();
		JSONObject quantitiesObject = jsonObject.getJSONObject("itemQuantities");
		for (String key : quantitiesObject.keySet()) {
			itemQuantities.put(key, quantitiesObject.getInt(key));
		}

		Order order = new Order();
		order.setOrderId(orderId);
		order.setCustomerName(customerName);
		order.setTax(tax);
		order.setSubTotal(subTotal);
		order.setTotal(total);
		order.setIsPaid(isPaid);
		order.setOrderDate(orderDate);
		order.setItems(items);
		order.setItemQuantities(itemQuantities);

		return order;
	}

	@Override
	public List<Order> convertToObjectList(String jsonArray) throws Exception {
		JSONArray jsonArrayObj = new JSONArray(jsonArray);
		List<Order> orders = new ArrayList<>();

		for (int i = 0; i < jsonArrayObj.length(); i++) {
			JSONObject jsonObject = jsonArrayObj.getJSONObject(i);

			int orderId = jsonObject.getInt("orderId");
			String customerName = jsonObject.getString("customerName");
			double tax = jsonObject.getDouble("tax");
			BigDecimal subTotal = new BigDecimal(jsonObject.getDouble("subTotal"));
			BigDecimal total = new BigDecimal(jsonObject.getDouble("total"));
			boolean isPaid = jsonObject.getBoolean("isPaid");
			Date orderDate = new SimpleDateFormat("yyyy-MM-dd").parse(jsonObject.getString("orderDate"));

			List<String> items = new ArrayList<>();
			JSONArray itemsArray = jsonObject.getJSONArray("items");
			for (int j = 0; j < itemsArray.length(); j++) {
				items.add(itemsArray.getString(j));
			}

			Map<String, Integer> itemQuantities = new HashMap<>();
			JSONObject quantitiesObject = jsonObject.getJSONObject("itemQuantities");
			for (String key : quantitiesObject.keySet()) {
				itemQuantities.put(key, quantitiesObject.getInt(key));
			}

			Order order = new Order();
			order.setOrderId(orderId);
			order.setCustomerName(customerName);
			order.setTax(tax);
			order.setSubTotal(subTotal);
			order.setTotal(total);
			order.setIsPaid(isPaid);
			order.setOrderDate(orderDate);
			order.setItems(items);
			order.setItemQuantities(itemQuantities);

			orders.add(order);
		}

		return orders;
	}

	@Override
	public void parseToGeneric() throws IOException {
		JSONObject jsonObject = new JSONObject(Data.ORDER_JSON_STRING);
		System.out.println("OrderID: " + jsonObject.getInt("orderId"));
	}

	@Override
	public void nullHandling() throws Exception {
		// sample order object
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Order order = new Order();
		order.setOrderId(1);
		order.setCustomerName(null); // I set customer name null
		order.setTax(8.5);
		order.setSubTotal(new BigDecimal(50.00));
		order.setTotal(new BigDecimal(54.25));
		order.setIsPaid(true);
		order.setOrderDate(sdf.parse("2023-01-15"));
		order.setItems(Arrays.asList("Laptop", "Mouse", "Keyboard"));
		order.setItemQuantities(Map.of("Laptop", 1, "Mouse", 2, "Keyboard", 1));
		
		JSONObject jsonObject = new JSONObject(order);
		String jsonString = jsonObject.toString();
		System.out.println(jsonString);

	}

}
