package com.example.login.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="User with specified Email Id is not found")
public class UserNotFoundException extends Exception{
	
}