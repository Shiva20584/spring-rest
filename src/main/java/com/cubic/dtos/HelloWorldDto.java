package com.cubic.dtos;

import java.util.Date;
import java.util.List;

//@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class HelloWorldDto {

	private String greeting;
	private long today;
	private List<String> quotes;

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public long getToday() {
		return today;
	}

	public void setToday(long today) {
		this.today = today;
	}

	public List<String> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<String> quotes) {
		this.quotes = quotes;
	}
		
}
