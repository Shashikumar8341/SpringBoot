package com.src2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllers {
	@Value("${myname}")
	private String name;

	@Autowired
	private Environment environment;

	@GetMapping("/path")
	public String Sayhello() {
		System.out.println("name:"+environment.getProperty("myname"));
		return "hello:" + name;

	}

}
