package com.src.controller;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.src.service.ServiceIMP;
import com.src.entity.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
	@Autowired
	private ServiceIMP serviceIMP;

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = serviceIMP.createUser(user);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
		User user = serviceIMP.getUserById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = serviceIMP.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User user) {
		user.setId(userId);
		User updatedUser = serviceIMP.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	// Build Delete User REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
		serviceIMP.deletebyid(userId);
		return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
	}

}
