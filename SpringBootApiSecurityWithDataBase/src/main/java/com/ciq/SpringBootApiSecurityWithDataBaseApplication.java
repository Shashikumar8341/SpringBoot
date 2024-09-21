package com.ciq;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ciq.entity.Role;
import com.ciq.entity.User;
import com.ciq.repository.RoleRepository;
import com.ciq.repository.UserRepository;

@SpringBootApplication
public class SpringBootApiSecurityWithDataBaseApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiSecurityWithDataBaseApplication.class, args);
	}

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		Role role = Role.builder().rname("user").build();
		Role role2 = Role.builder().rname("user").build();
		roleRepository.save(role);
		roleRepository.save(role2);
		User user = User.builder().uname("user").password(bCryptPasswordEncoder.encode("ciq")).email("ciq@gmail.com")
				.roles(Set.of(role)).build();
		User vidvaan = User.builder().uname("vidvaan").password(bCryptPasswordEncoder.encode("vidvaan"))
				.email("vidvaan@gmail.com").roles(Set.of(role)).build();
		User admin = User.builder().uname("admin").password(bCryptPasswordEncoder.encode("admin"))
				.email("admin@gmail.com").roles(Set.of(role2)).build();
	}

}
