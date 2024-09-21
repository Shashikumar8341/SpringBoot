package com.ciq.service;

import java.util.List;

import com.ciq.entity.UserDetailsRequestModel;

public interface UserService {
	public UserDetailsRequestModel createUser(UserDetailsRequestModel userDetailsRequestModel);

	public UserDetailsRequestModel getUserById(Integer id);

	public List<UserDetailsRequestModel> getAllUsers();

	public UserDetailsRequestModel updateUser(UserDetailsRequestModel userDetailsRequestModel);

	public void deletebyid(Integer id);


}