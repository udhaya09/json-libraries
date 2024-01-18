package com.example.jsonstudy.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.example.jsonstudy.data.Data;
import com.example.jsonstudy.data.Order;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
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

	@Override
	public void parseToGeneric() throws IOException {
		ObjectMapper jacksonObjectMapper = new ObjectMapper();
		JsonNode jsonObject = jacksonObjectMapper.readTree(Data.ORDER_JSON_STRING);
		System.out.println("OrderID: " + jsonObject.get("orderId").asInt());
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

		// default way of object to String conversion
		ObjectMapper objectMapper = new ObjectMapper();

		// to omit keys which has null values
		// objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);

		// to omit keys which has empty values
		// objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_EMPTY);

		// to omit keys which has default values
		// objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_DEFAULT);

		String jsonString = objectMapper.writeValueAsString(order);
		System.out.println(jsonString);
	}

}
