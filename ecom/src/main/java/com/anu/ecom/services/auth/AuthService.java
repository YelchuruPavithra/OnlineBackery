package com.anu.ecom.services.auth;

import com.anu.ecom.dto.SignupRequest;
import com.anu.ecom.dto.UserDto;

public interface AuthService 
{
	UserDto createUser(SignupRequest signupRequest);

	Boolean hasUserWithEmail(String email);
	
}
