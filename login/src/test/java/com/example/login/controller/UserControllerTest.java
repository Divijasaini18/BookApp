package com.example.login.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.login.Controller.UserController;
import com.example.login.Exception.UserAlreadyExistsException;
import com.example.login.Exception.UserNotFoundException;
import com.example.login.Model.Login;
import com.example.login.Model.User;
import com.example.login.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers=UserController.class)
public class UserControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private UserService service;
	@MockBean
	private Login login;
	private List<User> listuser;
	private Optional<User> opuser;
	private User user;
	@Before
	public void setUp() throws Exception {
		user = new User("saumya@gmail.com","Saumya","Saumya","Sharma","Saum21","New Delhi","New Delhi","45890299849");

		
	}
	@Test
	public void testRegisterUserSuccess() throws Exception {
		
		when(service.saveUser(Mockito.any(User.class))).thenReturn(user);
		String bookJson = new ObjectMapper().writeValueAsString(user);
		mockMvc.perform(post("/api/v1/user").contentType(MediaType.APPLICATION_JSON)
				.content(bookJson))
		.andExpect(status().isCreated());
	}
	@Test
	public void testRegisterUserFailure() throws Exception {
		when(service.saveUser(Mockito.any(User.class))).thenThrow(UserAlreadyExistsException.class);

		String bookJson = new ObjectMapper().writeValueAsString(user);
		mockMvc.perform(post("/api/v1/user").contentType(MediaType.APPLICATION_JSON)
				.content(bookJson))
				.andExpect(status().isConflict()).andDo(print());
	}
	
	// @Test
	// public void testGetUserByEmail() throws Exception {
	// 	service.saveUser(Mockito.any(User.class));
	// 	when(service.findByEmailId(Mockito.anyString())).
	// 			thenReturn(listuser);
	// 	mockMvc.perform(post("/api/users"))
	// 			.andExpect(status().isOk());
//				.andExpect(jsonPath("$.name", is("Testing with Mockito")))
		// 		.andDo(print());
		// verify(service,times(1)).findByEmailId(email)(Mockito.anyString());
	}
//	@Test
//	public void testUpdateUser() throws Exception {
//		when(service.updateUser(Mockito.anyString(),Mockito.anyString())).
//				thenReturn(user);
//		mockMvc.perform(put("/api/users/1234"))
//		        .andExpect(status().isOk())
//				.andExpect(jsonPath("$.name", is("Testing with Mockito")))
//				.andDo(print());
//		verify(service,times(1)).updateUser(Mockito.anyString(),Mockito.anyString());
//	}
	// @Test
	// public void testLogin() throws Exception {
		
	// 	when(login.loginUser(Mockito.anyString(),Mockito.anyString())).thenReturn(listuser);
	// 	String bookJson = new ObjectMapper().writeValueAsString(listuser);
	// 	mockMvc.perform(post("/api/user").contentType(MediaType.APPLICATION_JSON)
	// 			.content(bookJson))
	// 	.andExpect(status().isBadRequest());
	// }
	
//	@Test
//	public void testDeleteUser() throws Exception {
//		
//		when(service.deleteUser(Mockito.anyString())).thenReturn(user);
//		mockMvc.perform(delete("/api/users/1234"))
//		//.andExpect(status().isOk())
////		.andExpect(jsonPath("$.name", is("Testing with Mockito")))
//		.andDo(print());
//          verify(service,times(1)).deleteUser(Mockito.anyString());
//}
//	
	

// }


