
package com.example.login.service;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.login.Exception.UserAlreadyExistsException;
import com.example.login.Model.User;
import com.example.login.Repository.UserRepository;
import com.example.login.Service.UserServiceImpl;
import com.example.login.exception.BookAlreadyExistsException;



@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
	
	@Mock
	private UserRepository userRepository;
	@InjectMocks
	private UserServiceImpl service;
	User user;
	List<User> listuser;
	Optional<User> optUser;
	@Before
	public void setUp() throws Exception {
		user = new User("saumya@gmail.com","Saumya","Saumya","Sharma","Saum21","New Delhi","New Delhi","45890299849");
		optUser = Optional.of(user);
	}
	@Test
	public void testAddUserSuccess() throws BookAlreadyExistsException, UserAlreadyExistsException {
		// BookRepository repo = Mockito.mock(BookRepository.class);
//		when(favRepository.findByBookIdAndUsername(Mockito.anyString(),Mockito.anyString())).
//					thenReturn(listfav);
		when(userRepository.save(Mockito.any(User.class))).
					thenReturn(user);
		User addedBook = service.saveUser(user);
//		assertEquals(fav.getBookId(), addedBook.getBookId());
//		verify(favRepository).findByBookIdAndUsername(Mockito.anyString(),Mockito.anyString());
		verify(userRepository).save(Mockito.any());
	}


}
