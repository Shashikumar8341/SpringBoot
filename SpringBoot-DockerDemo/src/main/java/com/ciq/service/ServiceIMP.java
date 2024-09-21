package com.ciq.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciq.entity.UserDetailsRequestModel;
import com.ciq.repo.UserRepo;

@Service
public class ServiceIMP implements UserService {

	@Autowired
	private UserRepo userRepository;

	@Override
	public UserDetailsRequestModel createUser(UserDetailsRequestModel user) {
		return userRepository.save(user);
	}

	@Override
	public UserDetailsRequestModel getUserById(Integer id) {
		Optional<UserDetailsRequestModel> optional = userRepository.findById(id);
		return optional.get();
	}

	@Override
	public List<UserDetailsRequestModel> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public UserDetailsRequestModel updateUser(UserDetailsRequestModel userDetailsRequestModel) {
		UserDetailsRequestModel existingUser = userRepository.findById(userDetailsRequestModel.getId()).get();
		existingUser.setFirstName(userDetailsRequestModel.getFirstName());
		existingUser.setLastName(userDetailsRequestModel.getLastName());
		existingUser.setEmail(userDetailsRequestModel.getEmail());
		existingUser.setPassword(userDetailsRequestModel.getPassword());
		UserDetailsRequestModel updatedUser = userRepository.save(existingUser);
		return updatedUser;
	}

	@Override
	public void deletebyid(Integer id) {
		userRepository.deleteById(id);
	}

}
