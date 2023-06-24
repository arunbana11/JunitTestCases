package com.it.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import com.it.binding.UserBinding;
import com.it.entity.UserEntityDetails;
import com.it.repo.UserDetailsRepo;
import com.it.service.UserServcie;

@SpringBootTest(classes = Test_UserDetails.class)
public class Test_UserDetails {

	@Mock
	UserDetailsRepo detailsRepoMock;

	@InjectMocks
	UserServcie servcieMock;

	@Mock
	UserBinding userBinding;
	@Mock
	UserEntityDetails userDetails ;

	List<UserEntityDetails> entityList=new ArrayList<>();
	List<UserBinding> bindingList=new ArrayList<>();
	@BeforeEach
	void before() {
		userBinding.setUserName("arun");
		userBinding.setCity("adoni");
		userBinding.setEmail("arun@gmail");
		userBinding.setPwd("123");
		userBinding.setSalary(25000.00);
		entityList.add(new UserEntityDetails(222, "kumar", "hyd", 30000.9, "kumar@gmail", "789"));
		entityList.add(new UserEntityDetails(111, "arun","adoni", 25000.00, "arun@gmail", "123"));
		
		
	}

	@Test
	@Disabled
	void test_saveUser() {

	//	UserEntityDetails userDetails = new UserEntityDetails();
		BeanUtils.copyProperties(userBinding, userDetails);
		userDetails.setUserId(101);
		when(detailsRepoMock.save(any(UserEntityDetails.class))).thenReturn(userDetails);

		Integer saveUser = servcieMock.saveUser(userBinding);
		assertEquals(userDetails.getUserId(), saveUser);
		// assertE

	}
	@Test
	@Disabled
	void test_getUser()
	{
		entityList.forEach(entity ->{
			UserBinding userBinding=new UserBinding();
			BeanUtils.copyProperties(entity,userBinding );
			bindingList.add(userBinding);
		});
          when(detailsRepoMock.findAll()).thenReturn(entityList);
          List<UserBinding> details = servcieMock.getUserDetails();
          assertEquals(bindingList.get(1).getEmail(), details.get(1).getEmail());
	}
	
	void test_getCity() {
		
		when(detailsRepoMock.findByCity("hyd")).thenReturn(new UserEntityDetails(222, "kumar", "hyd", 30000.9, "kumar@gmail", "789"));
		
		UserBinding city = servcieMock.getCity("hyd");
		assertEquals("hyd", city);
	}

}
