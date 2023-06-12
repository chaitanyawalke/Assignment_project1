package com.app.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dtos.LoginRequestDto;
import com.app.dtos.ResponseStatusDto;
import com.app.entities.User;
import com.app.repositories.ReminderRepository;
import com.app.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ReminderRepository reminderRepository;

	@Override
	public ResponseStatusDto addUserDetails(User user) {
		ResponseStatusDto status = new ResponseStatusDto();
		User existingUser = userRepository.findUserByUserName(user.getUserName());
		if(existingUser != null) {
			 status.setStatusCode(501);
			 status.setStatus("User with name "+user.getUserName()+" already exists.");
		}
		else {
			this.userRepository.save(user);
			status.setStatusCode(200);
			status.setStatus("User registered successfully.");
			status.setUser(user);
		}
		return status;
	}

	@Override
	public ResponseStatusDto fetchUserDetails(Integer userId) {
		ResponseStatusDto status = new ResponseStatusDto();
		User existingUser = userRepository.findById(userId).orElseThrow();
		status.setStatusCode(200);
		status.setStatus("Login successfull.");
		status.setUser(existingUser);
		return status;
	}

	@Override
	public ResponseStatusDto authenticateUser(LoginRequestDto userLoginDto) {
		ResponseStatusDto status = new ResponseStatusDto();
		User existingUser = userRepository.findUserByUserName(userLoginDto.getUserName());
		if(existingUser == null) {
			status.setStatusCode(501);
			status.setStatus("User with name "+userLoginDto.getUserName()+" does not exist.");
			return status;
		}
		else {
			if(!userLoginDto.getPassword().equals(existingUser.getPassword())) {
				status.setStatusCode(501);
				status.setStatus("Invalid Password.");
				return status;
			}
			else {
				status.setStatusCode(200);
				status.setStatus("Login successfull.");
				status.setUser(existingUser);
			}
		}
		return status;
	}

}
