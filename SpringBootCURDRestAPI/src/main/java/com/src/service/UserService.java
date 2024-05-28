package com.src.service;

import java.util.List;

import com.src.entity.User;

public interface UserService {
	public User createUser(User user);

	public User getUserById(Long userId);

	public List<User> getAllUsers();

	public User updateUser(User user);

	public void deletebyid(Long userId);
}