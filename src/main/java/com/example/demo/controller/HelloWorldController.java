package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);

	@RequestMapping(value = "/reverseString", method = RequestMethod.GET)
	public ResponseEntity<String> getReverseString(@RequestParam("inputString") String inputString) {
		LOGGER.info("input string :", inputString);
		String reversedString = "";
		try {
			String words[] = inputString.split("\\s");
			for (int i = 0; i < words.length; i++) {
				if (i == words.length - 1)
					reversedString = words[i] + reversedString;
				else
					reversedString = " " + words[i] + reversedString;
			}
			LOGGER.info("reversed string :", reversedString);
		} catch (Exception e) {
			LOGGER.error("exception occured while processing reverese tring ", e);
		}
		return new ResponseEntity<>(reversedString, HttpStatus.OK);
	}

}
