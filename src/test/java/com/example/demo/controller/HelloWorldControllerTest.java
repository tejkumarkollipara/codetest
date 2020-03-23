package com.example.demo.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import junit.framework.Assert;

public class HelloWorldControllerTest {

	private HelloWorldController helloWorldController;
	
	@Before
	public void setUp() throws Exception {
		helloWorldController = new HelloWorldController();
	}

	@After
	public void tearDown() throws Exception {
		helloWorldController = null;
	}

	@Test
	public void testReversedString() {
		String reversedStringExpected = "world hello";
		ResponseEntity<String> reversedStringEntity = helloWorldController.getReverseString("hello world");
		String reversedString = reversedStringEntity.getBody();
		Assert.assertEquals(reversedStringExpected, reversedString);
	}
	
	@Test
	public void testReversedStringWithMultipleWords() {
		String reversedStringExpected = "world awesome hello";
		ResponseEntity<String> reversedStringEntity = helloWorldController.getReverseString("hello awesome world");
		String reversedString = reversedStringEntity.getBody();
		Assert.assertEquals(reversedStringExpected, reversedString);
	}
	
	@Test
	public void testReversedStringWithSingleWords() {
		String reversedStringExpected = "hello";
		ResponseEntity<String> reversedStringEntity = helloWorldController.getReverseString("hello");
		String reversedString = reversedStringEntity.getBody();
		Assert.assertEquals(reversedStringExpected, reversedString);
	}

}
