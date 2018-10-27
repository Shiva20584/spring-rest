package com.cubic.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cubic.dtos.HelloWorldDto;

public class InMemoryDatabase {

	public static Map<String, HelloWorldDto> helloDtoDb;
	
	static {
		helloDtoDb = new HashMap<String, HelloWorldDto>();

		// 1st record
		HelloWorldDto dto1 = new HelloWorldDto();
		dto1.setGreeting("Good Morning");
		dto1.setToday(System.currentTimeMillis());

		List<String> quotes1 = new ArrayList();
		quotes1.add("Optimism is the faith that leads to achievement. "
				+ "Nothing can be done without hope and confidence.");
		quotes1.add("Only I can change my life. No one can do it for me.");
		dto1.setQuotes(quotes1);

		// second record
		HelloWorldDto dto2 = new HelloWorldDto();
		dto2.setGreeting("Good Evening");
		dto2.setToday(System.currentTimeMillis());

		List<String> quotes2 = new ArrayList();
		quotes2.add("Good Evening maam");
		quotes2.add("Good Evening Sir");
		dto2.setQuotes(quotes2);

		// third record
		HelloWorldDto dto3 = new HelloWorldDto();
		dto3.setGreeting("Good Night");
		dto3.setToday(System.currentTimeMillis());

		List<String> quotes3 = new ArrayList();
		quotes3.add("Good Night Sir");
		quotes3.add("Good Night maam");
		dto3.setQuotes(quotes3);

		// initialize map
		helloDtoDb.put("morning", dto1);
		helloDtoDb.put("evening", dto2);
		helloDtoDb.put("night", dto3);
	}
	
	

}
