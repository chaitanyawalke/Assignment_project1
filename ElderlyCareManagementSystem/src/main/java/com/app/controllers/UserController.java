package com.app.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.LoginRequestDto;
import com.app.dtos.ResponseStatusDto;
import com.app.dtos.UserSignupDto;
import com.app.entities.User;
import com.app.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping("/signup")
	public ResponseStatusDto saveUserDetails(@RequestBody UserSignupDto user){
		User newUser = mapper.map(user, User.class);
		return userService.addUserDetails(newUser);	
	}
	
	@PostMapping("/getUser")
	public ResponseStatusDto getUserDetails(@RequestBody Integer userid){
		return userService.fetchUserDetails(userid);
	}
	
	@PostMapping("/signin")
	public ResponseStatusDto validateUser(@RequestBody LoginRequestDto dto){
		return userService.authenticateUser(dto);
	}
}
