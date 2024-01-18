package com.example.jsonstudy.util;

import java.util.List;

import com.example.jsonstudy.data.Order;
import com.google.gson.Gson;
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

}
