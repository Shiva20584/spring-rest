package com.cubic.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cubic.dtos.HelloWorldDto;
import com.cubic.utils.InMemoryDatabase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/hello")
public class HelloWorldController {
	
	@RequestMapping(value="", method= RequestMethod.GET)
	public List<HelloWorldDto> getHellos() {
		return new ArrayList(InMemoryDatabase.helloDtoDb.values());
	}
	
	@RequestMapping(value="/{key}", method= RequestMethod.GET)
	public HelloWorldDto getHelloByKey(@PathVariable(value ="key") String key) {
		Map<String,HelloWorldDto> dtoMap = InMemoryDatabase.helloDtoDb;
		return dtoMap.get(key);
	}
	
	@RequestMapping(value="/{key}", method= RequestMethod.DELETE)
	public void deleteHelloByKey(@PathVariable(value ="key") String key) {
		Map<String,HelloWorldDto> dtoMap = InMemoryDatabase.helloDtoDb;
		dtoMap.remove(key);
	}
	

	
	@RequestMapping(value="/give", method= RequestMethod.GET)
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
	
	@RequestMapping(value = "/take", method = RequestMethod.POST)
	public HelloWorldDto takeGeetings(@RequestBody HelloWorldDto helloWorldDto) throws JsonProcessingException {
		System.out.println("Input : "  + new ObjectMapper().writeValueAsString(helloWorldDto));
		helloWorldDto.setGreeting("Goooooood Evening");
		System.out.println("Output : "  + new ObjectMapper().writeValueAsString(helloWorldDto));
		return helloWorldDto;
	}
	
}
