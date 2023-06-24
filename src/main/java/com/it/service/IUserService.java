package com.it.service;

import java.util.List;

import com.it.binding.UserBinding;

public interface IUserService {

	public Integer saveUser(UserBinding userBinding);
	
	public List<UserBinding> getUserDetails();
	
	public UserBinding getCity(String msg);
	
}
