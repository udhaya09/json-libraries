package com.example.jsonstudy.util;

import java.io.IOException;
import java.util.List;

import com.example.jsonstudy.data.Order;

public interface JsonUtil {

	String convertToJsonString(List<Order> orders) throws Exception;

	String convertToJsonString(Order order) throws Exception;

	Order convertToObject(String json) throws Exception;

	List<Order> convertToObjectList(String jsonArray) throws Exception;
	
	void parseToGeneric() throws IOException;
	
	void nullHandling() throws Exception;
}
