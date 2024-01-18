package com.example.jsonstudy;

import com.example.jsonstudy.data.Data;
import com.example.jsonstudy.util.GoogleJsonUtil;
import com.example.jsonstudy.util.JacksonJsonUtil;
import com.example.jsonstudy.util.JsonUtil;
import com.example.jsonstudy.util.OrgJsonUtil;

public class DriverClass {

	public static void main(String[] args) throws Exception {

		// 1: Jackson
		// 2: Gson
		// 3. Org.Json

		int ch = 3;
		JsonUtil jsonUtil;
		switch (ch) {
		case 1:
			jsonUtil = new JacksonJsonUtil();
			break;
		case 2:
			jsonUtil = new GoogleJsonUtil();
			break;
		case 3:
			jsonUtil = new OrgJsonUtil();
			break;
		default:
			jsonUtil = new JacksonJsonUtil();
		}

		jsonUtil.convertToJsonString(Data.ORDER_OBJECT());
		jsonUtil.convertToJsonString(Data.ORDER_LIST_OBJECT());
		jsonUtil.convertToObject(Data.ORDER_JSON_STRING);
		jsonUtil.convertToObjectList(Data.ORDER_LIST_JSON_STRING);
		jsonUtil.parseToGeneric();
		jsonUtil.nullHandling();
		System.out.println(jsonUtil.getClass().getName() + " Done");
	}

}
