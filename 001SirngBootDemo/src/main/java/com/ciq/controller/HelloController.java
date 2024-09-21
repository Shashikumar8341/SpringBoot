package com.ciq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hai")
	public @ResponseBody  String sayhello() {
		return "Hello Bhargav";
		
	}
}
