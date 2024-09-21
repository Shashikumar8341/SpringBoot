package com.ciq.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import com.ciq.entity.UserDetailsRequestModel;
import com.ciq.service.UserService;


@RestController
@RequestMapping("users")
public class UserController {
	

    @Autowired
    UserService userService;
 
    @PostMapping
    public UserDetailsRequestModel createUser(@RequestBody UserDetailsRequestModel requestUserDetails) {
    	UserDetailsRequestModel returnValue = new UserDetailsRequestModel();
                
      
        BeanUtils.copyProperties(requestUserDetails, userService);

        UserDetailsRequestModel createdUser = userService.createUser(requestUserDetails);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }
   
}