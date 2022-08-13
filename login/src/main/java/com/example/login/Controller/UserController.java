package com.example.login.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.Exception.UserAlreadyExistsException;
import com.example.login.Exception.UserNotFoundException;
import com.example.login.Model.Login;
import com.example.login.Model.User;
import com.example.login.Service.SecurityTokenGenerator;
import com.example.login.Service.UserService;

@RestController
@RequestMapping(value = "/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController{

    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    // @Autowired
    // private SecurityTokenGenerator securityTokenGenerator;
    @PostMapping(value="/userlogin")
    // @ResponseBody
    //@RequestMapping(value = "/user", method = RequestMethod.POST, consumes="application/json")
    public ResponseEntity<?> loginUser(@RequestBody Login login) throws UserNotFoundException
    {
        return new ResponseEntity<>(userService.loginUser(login),HttpStatus.OK);
    }

    // @PostMapping(value="/authenticate")
    // // @ResponseBody
    // //@RequestMapping(value = "/user", method = RequestMethod.POST, consumes="application/json")
    // public ResponseEntity<?> createAuthenticationToken(@RequestBody Login login) throws UserNotFoundException
    // {
    //     try{
    //         authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(),login.getPassword()));
    //     }
    //     catch(BadCredentialsException e)
    //     {
    //         throw new Exception("Incorrect username or password");
    //     }
    //     final User user=userService.getAllUsersByEmailId(login.getEmail());
    //     final String jwt=securityTokenGenerator.generateToken(user);
    //     return ResponseEntity.ok(new AuthenticationResponse(jwt));
    // }

    @PostMapping(value="/user")
    @ResponseBody
    //@RequestMapping(value = "/user", method = RequestMethod.POST, consumes="application/json")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyExistsException
    {
        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
    }
    //@GetMapping(value="/users",produces = MediaType.APPLICATION_JSON_VALUE)
    //@GetMapping(value="/users")
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() throws Exception
    {
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }


    @PostMapping(value="/userupdate")
    public ResponseEntity<?> updateUser(@RequestBody User user)throws UserNotFoundException
    {
    	return new ResponseEntity<>(userService.updateUser(user,user.getEmail()), HttpStatus.OK);
    }
    //@GetMapping(value="/users/{email}",produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value="/users/{email}")
    public ResponseEntity<?> getAllUsersByEmailId(@PathVariable String email) throws UserNotFoundException
    {
        return new ResponseEntity<>(userService.findByEmailId(email),HttpStatus.FOUND);
    }
    //@DeleteMapping(value="/users/{email}",produces = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping(value="/users/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable String email) throws UserNotFoundException
    {
        return new ResponseEntity<>(userService.deleteUserByEmailId(email),HttpStatus.OK);
    }
}