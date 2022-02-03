package com.example.usermanagement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.usermanagement.entity.User;
import com.example.usermanagement.repository.UserRepo;
import com.example.usermanagement.service.UserService;
@RunWith(SpringRunner.class)
@SpringBootTest
class UserManagementSystemApplicationTests {

	@Autowired
	private UserService service;



	 @MockBean
	private UserRepo userRepo;

	 @Test
		public void getAllUsersTest() {
		when(userRepo.findAll()).thenReturn(Stream
		.of(new User (1,"Bangalore","manoj@gmail.com","Manoj","suv123"),
		new User(2,"Bangalore","john@gmail.com","John","john123")).collect
		(Collectors.toList()));
		assertEquals(2,service.getAllUsers().size());
		}
		
		@Test
		public void getAllUsersByCityTest(){
			String city="Bangalore";
			when(userRepo.findByCity(city)).thenReturn(Stream
					.of(new User (1,"Pune","raj@gmail.com","Raj","raj123")).collect(Collectors.toList()));
			assertEquals(1,service.getAllUsersByCity(city).size());
			
		}
		
		@Test
		public void saveUserTest() {
			User user = new User(3,"Mumbai","nag@gmail.com","Naga","naga123");
			when(userRepo.save(Mockito.any(User.class)))
			.thenAnswer(i -> i.getArguments()[0]);
			}
		
		
		    
			@Test
			public void getUserById(){
			User user = new User();
			user.setUid(8);
			when(userRepo.findById(user.getUid())).thenReturn(Optional.of(user));
			User expected = (User) service.getUserById(user.getUid());
			assertThat(expected).isSameAs(user);
			verify(userRepo).findById(user.getUid());
			}
		

}
