package com.src.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.src.entity.Address;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {
	@Autowired
	public JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void run(String... args) throws Exception {
		System.out.println(jdbcTemplate);
		jdbcTemplate.query("select *from Address", new BeanPropertyRowMapper(Address.class)).forEach(System.out::println);;
	}

}
