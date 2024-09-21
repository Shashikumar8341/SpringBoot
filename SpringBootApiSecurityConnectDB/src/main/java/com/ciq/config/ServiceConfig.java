package com.ciq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ServiceConfig {

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();

	}

	@Bean
	public UserDetailsService userDetailsService() {

		UserDetails ciq = User.builder().username("ciq").password("{noop}ciq").roles("USER").build();
//		UserDetails ciq = User.builder().username("ciq").password("$2a$10$Oviz/.nthp.FPZqh2TLlGe7A2na06UmZ33XcjA0583nDgReBGsSmy\r\n").roles("USER").build();

		UserDetails vidvaan = User.builder().username("vidvaan").password("{noop}vidvaan").roles("USER").build();
//		UserDetails vidvaan = User.builder().username("vidvaan").password("$2a$10$uwndrongkC9KzfET16DQFOlm1z9XQS1gl/MsKcapHTm/celSF0DdO\r\n").roles("USER").build();

		UserDetails admin = User.builder().username("admin").password("{noop}admin").roles("ADMIN").build();
//		UserDetails admin = User.builder().username("admin").password("$2a$10$7Dzy.OCxvwTP3v.WQ20wBO9mjnB4gLdACIwy57w9shAjbW5iHSlb2").roles("ADMIN").build();

		return new InMemoryUserDetailsManager(ciq, vidvaan, admin);
	}

	// Configuring HttpSecurity
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		return http.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(
						auth -> auth.requestMatchers("/public/home", "/public/about", "/rest/**", "/MySQl-console/**")
								.permitAll().requestMatchers("/private/findAll", "/private/findById").hasRole("USER")
								.requestMatchers("/admin").hasRole("ADMIN").anyRequest().authenticated())
				.formLogin(Customizer.withDefaults()).headers(headers -> headers.frameOptions(a -> a.disable()))
				.csrf(x -> x.ignoringRequestMatchers("/MySQl-console/**", "/rest/**")).build();
	}
}
