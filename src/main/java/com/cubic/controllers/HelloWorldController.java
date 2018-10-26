package com.cubic.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cubic.dtos.HelloWorldDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/hello")
public class HelloWorldController {

	
	@RequestMapping(value="/give", method= RequestMethod.GET)
//	@ResponseBody
	public HelloWorldDto getGreetings() throws JsonProcessingException {
		HelloWorldDto hello = new HelloWorldDto();
		hello.setGreeting("Good Morning");
		hello.setToday(System.currentTimeMillis());
		
		List<String> quotes = new ArrayList();
		quotes.add("Optimism is the faith that leads to achievement. "
				+ "Nothing can be done without hope and confidence.");
		quotes.add("Only I can change my life. No one can do it for me.");
		hello.setQuotes(quotes);
		
		System.out.print(new ObjectMapper().writeValueAsString(hello));
		
		return hello;
	}
	
	
	public void takeGeetings() {
		
	}
	
}
