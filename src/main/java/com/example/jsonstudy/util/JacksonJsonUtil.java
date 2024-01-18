package com.example.jsonstudy.util;

import java.util.List;

import com.example.jsonstudy.data.Order;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonJsonUtil implements JsonUtil {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public String convertToJsonString(List<Order> orders) throws Exception {
		return objectMapper.writeValueAsString(orders);
	}

	@Override
	public String convertToJsonString(Order order) throws Exception {
		return objectMapper.writeValueAsString(order);
	}

	@Override
	public Order convertToObject(String json) throws Exception {
		return objectMapper.readValue(json, Order.class);
	}

	@Override
	public List<Order> convertToObjectList(String jsonArray) throws Exception {
		return objectMapper.readValue(jsonArray, new TypeReference<List<Order>>() {
		});
	}

}
