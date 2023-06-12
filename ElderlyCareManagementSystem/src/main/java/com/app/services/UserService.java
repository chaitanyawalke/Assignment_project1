package com.app.services;

import com.app.dtos.LoginRequestDto;
import com.app.dtos.ResponseStatusDto;
import com.app.entities.User;

public interface UserService {

	ResponseStatusDto addUserDetails(User user);
	ResponseStatusDto fetchUserDetails(Integer userId);
	ResponseStatusDto authenticateUser(LoginRequestDto userLoginDto);
}
