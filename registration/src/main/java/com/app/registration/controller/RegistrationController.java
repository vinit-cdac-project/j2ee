package com.app.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.app.registration.model.User;
import com.app.registration.service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	
	private RegistrationService Service;
	
	@PostMapping("/registeruser")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmailId=user.getEmailid();
		if(tempEmailId!=null && !"".equals(tempEmailId)) {
			User userobj = Service.fetchUserByEmailId(tempEmailId);
			if (userobj!=null) {
				
				throw new Exception("User with "+tempEmailId+" already Exits");
			}
			
		}
		
		User userObj=null;
		userObj=Service.saveUser(user);
		return userObj;
	}
	
	@PostMapping("/login") 
	public User loginUser(@RequestBody User user)throws Exception {
		String tempEmailId=user.getEmailid();
		String tempPass= user.getPassword();
		User userObj=null;
		if(tempEmailId !=null && tempPass !=null) {
			userObj= Service.fetchUserByEmailIdAndPassword(tempEmailId,tempPass);
			
			}
		if(userObj ==null){
			throw new Exception("Bad Credentials");
		}
		   return userObj;
		
		
		
	}
	
}

