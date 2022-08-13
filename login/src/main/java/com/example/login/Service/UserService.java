package com.example.login.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.login.Exception.UserAlreadyExistsException;
import com.example.login.Exception.UserNotFoundException;
import com.example.login.Model.Login;
import com.example.login.Model.User;


@Service
public interface UserService {
	public User saveUser(User user) throws UserAlreadyExistsException;
	public List<User> getAllUsers() throws Exception;
	public User updateUser(User user, String email)throws UserNotFoundException;
	public boolean deleteUserByEmailId(String email) throws UserNotFoundException;
	public List<User> findByEmailId(String email) throws UserNotFoundException;
	public Optional<User> loginUser(Login login) throws UserNotFoundException;
}