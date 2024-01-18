package com.example.jsonstudy.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

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

}
