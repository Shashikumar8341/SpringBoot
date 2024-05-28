package com.src.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.src.entity.Students;

@RestController
@RequestMapping("/bean")
public class SController {
	@GetMapping("/url")
	public Students getview() {
		return new Students("shashi", 28);
	}
}
