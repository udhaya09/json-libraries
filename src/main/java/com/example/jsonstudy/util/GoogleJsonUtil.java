package com.example.jsonstudy.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.example.jsonstudy.data.Data;
import com.example.jsonstudy.data.Order;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class GoogleJsonUtil implements JsonUtil {

	private final Gson gson = new Gson();

	@Override
	public String convertToJsonString(List<Order> orders) throws Exception {
		return gson.toJson(orders);
	}

	@Override
	public String convertToJsonString(Order order) throws Exception {
		return gson.toJson(order);
	}

	@Override
	public Order convertToObject(String json) throws Exception {
		return gson.fromJson(json, Order.class);
	}

	@Override
	public List<Order> convertToObjectList(String jsonArray) throws Exception {
		return gson.fromJson(jsonArray, new TypeToken<List<Order>>() {
		}.getType());
	}

	@Override
	public void parseToGeneric() throws IOException {
		JsonObject jsonObject = new JsonParser().parse(Data.ORDER_JSON_STRING).getAsJsonObject();
		System.out.println("OrderID: " + jsonObject.get("orderId").getAsInt());
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

		// Gson gsonObject = new Gson();
		Gson gsonObject = new GsonBuilder().serializeNulls().create();
		String jsonString = gsonObject.toJson(order);
		System.out.println(jsonString);

	}

}
