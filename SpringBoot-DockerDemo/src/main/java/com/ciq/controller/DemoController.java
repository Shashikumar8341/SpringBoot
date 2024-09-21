package com.ciq.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/docker")
public class DemoController {
//
//	@GetMapping("/path")
//	public String getMethodName(@RequestBody() String param) {
//		return new String("shashi");
//	}
	 @GetMapping("/response")
	    @ResponseBody
	    public String postResponseController(
	      @RequestBody String loginForm) {
	        return new String("Thanks For Posting!!!");
	     }
	
}
