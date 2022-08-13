package com.example.login.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.login.Exception.UserAlreadyExistsException;
import com.example.login.Exception.UserNotFoundException;
import com.example.login.Model.Login;
import com.example.login.Model.User;
import com.example.login.Repository.UserRepository;



@Service
@Transactional
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User saveUser(User user) throws UserAlreadyExistsException{
        // user.setUserCode(UUID.randomUUID().toString());
    	if(userRepository.findById(user.getEmail()).isPresent())
        {
            throw new UserAlreadyExistsException();
        }
        return userRepository.save(user);

    }
    @Override
    public Optional<User> loginUser(Login login) throws UserNotFoundException{
        // user.setUserCode(UUID.randomUUID().toString());
        Optional<User> users=userRepository.findByEmailId(login.getEmail());
    	if(users.isEmpty())
        {
            throw new UserNotFoundException();
        }
        //else
        // users.get()
        //return new Login(users.get().getEmail(), users.get().getPassword()); 
        return userRepository.findByEmailId(login.getEmail());

    }
    @Override
    public List<User> getAllUsers() throws Exception{
    	return userRepository.findAll();
    }
    @Override
    public User updateUser(User user, String email)throws UserNotFoundException{
    	if(userRepository.findById(email).isEmpty())
    		throw new UserNotFoundException();
    	return userRepository.save(user);
    }
    @Override
    public boolean deleteUserByEmailId(String email) throws UserNotFoundException{
    	boolean flag = false;
        if(userRepository.findById(email).isEmpty())
        {
            throw new UserNotFoundException();
        }
        else {
        	userRepository.deleteById(email);
            flag = true;
        }
        return flag;

    }
    @Override
    public List<User> findByEmailId(String email) throws UserNotFoundException{
    	if(userRepository.findAllUsersFromEmailId(email).isEmpty())
        {
            throw new UserNotFoundException();
        }
        return userRepository.findAllUsersFromEmailId(email);

    }
    
}
