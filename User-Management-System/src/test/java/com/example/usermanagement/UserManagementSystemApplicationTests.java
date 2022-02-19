package com.example.usermanagement;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;


import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.entity.Customer;
import com.example.usermanagement.entity.User;
import com.example.usermanagement.feignclient.FeignClient1;
import com.example.usermanagement.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class UserManagementSystemApplicationTests {

	@Autowired
	private UserService service;
	
	 
		@Before
		public void init() {
			MockitoAnnotations.initMocks(this);
		}
	@MockBean
	private FeignClient1 feignClient;
	
	 @Autowired
	 private MockMvc mockMvc;

	 @MockBean
	 private RestTemplate restTemplate;
	 
	 @Autowired
	 private WebApplicationContext context;

	
	 ObjectMapper om = new ObjectMapper();
		
	 @Before
	 private void setUp()
	 {
	 mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	 }

	 
    @SuppressWarnings("unchecked")
	@Test
    public void getAll() throws Exception {

	UserDto[] user = new UserDto[2];
	 user[0] = new UserDto(1,"Manoj","Bangalore","manoj@gmail.com");
	 user[1] = new UserDto(2,"John","Pune","john@gmail.com");
	
	 when( restTemplate.getForObject(any(String.class),any(Class.class))).thenReturn(user);
	 mockMvc.perform(get("/user/getAllCustomer")).andExpect(status().isOk());
	 assertEquals(user.length , 2);
	   
	
}
   
    @Test
    public void getCustomerbyFeignTest() throws Exception
    {
    
    List<UserDto> user = new ArrayList<UserDto>();
    UserDto user1 = new UserDto(1,"Manoj","Bangalore","manoj@gmail.com");
    UserDto user2 = new UserDto(2,"John","Pune","john@gmail.com");
    user.add(user1);
    user.add(user2);
    when(feignClient.getUser()).thenReturn(user);
    mockMvc.perform(get("/user/getAll")).andExpect(status().isOk());
    //assertEquals(customer. , 1);

    }
  

}




