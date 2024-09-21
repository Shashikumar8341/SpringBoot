package com.ciq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ciq")
public class Log4jApplication  {

	public static void main(String[] args) {
		SpringApplication.run(Log4jApplication.class, args);
	}

}
