package com.src.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.src.entity.User;
import com.src.repository.UserRepository;
@Service
public class ServiceIMP implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long userId) {
		Optional<User>optional=userRepository.findById(userId);
		return optional.get();
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {
		 User existingUser = userRepository.findById(user.getId()).get();
	        existingUser.setFirstName(user.getFirstName());
	        existingUser.setLastName(user.getLastName());
	        existingUser.setEmail(user.getEmail());
	        User updatedUser = userRepository.save(existingUser);
	        return updatedUser;	}

	@Override
	public void deletebyid(Long userid) {
		userRepository.deleteById(userid);
	}

}
