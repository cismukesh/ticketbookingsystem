package com.cinematicket.services.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cinematicket.entities.User;
import com.cinematicket.repository.UserRepository;
import com.cinematicket.services.UserService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

	@MockBean
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveUser() {
		User user = new User();
		user.setId(1l);
		user.setEmail("test@test.com");
		user.setPassword("test");
		user.setUsername("test user");
		when(userRepository.save(Mockito.any(User.class))).thenReturn(user);
		User userSaved = userService.saveUser(user);

		assertEquals(user.getId(), userSaved.getId());
	}

	@Test
	public void testGetUserById() {
		User user = new User();
		user.setId(1l);
		user.setEmail("test@test.com");
		user.setPassword("test");
		user.setUsername("test user");
		when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));

		Optional<User> userOpt = userService.getUserById(1l);

		assertEquals(userOpt.get().getEmail(), user.getEmail());
	}

	@Test
	public void testGetUserByEmailPassword() {
		User user = new User();
		user.setId(1l);
		user.setEmail("test@test.com");
		user.setPassword("test");
		user.setUsername("test user");

		when(userRepository.findByEmailAndPassword(Mockito.anyString(), Mockito.anyString())).thenReturn(user);

		User userFetch = userService.getUserByEmailPassword("test@test.com", "test");

		assertEquals(userFetch.getEmail(), user.getEmail());
	}

}
