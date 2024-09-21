package com.ciq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SpringBootApiSecurityConnectDbApplicationTests {
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Test
	void contextLoads() {
		System.out.println(bCryptPasswordEncoder.encode("ciq"));
		System.out.println(bCryptPasswordEncoder.encode("vidvaan"));
		System.out.println(bCryptPasswordEncoder.encode("admin"));
	}

}
