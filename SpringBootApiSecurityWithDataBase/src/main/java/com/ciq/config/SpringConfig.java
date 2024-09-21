package com.ciq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringConfig {

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	UserDetailsService detailsService() {

		UserDetails ciq = User.builder().username("ciq").password("ciq").roles("ROLES_USER").build();
		UserDetails vidvaan = User.builder().username("vidvaan").password("vidvaan").roles("ROLES_USER").build();
		UserDetails admin = User.builder().username("admin").password("admin").roles("ROLES_USER").build();
		return new InMemoryUserDetailsManager(ciq, vidvaan, admin);
	}
}
