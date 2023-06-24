package com.it.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.binding.UserBinding;
import com.it.entity.UserEntityDetails;
import com.it.repo.UserDetailsRepo;

@Service
public class UserServcie implements IUserService {

	@Autowired
	private UserDetailsRepo detailsRepo;

	@Override
	public Integer saveUser(UserBinding userBinding) {
		UserEntityDetails entityDetails = new UserEntityDetails();
		BeanUtils.copyProperties(userBinding, entityDetails);
		UserEntityDetails details = detailsRepo.save(entityDetails);

		return details.getUserId();
	}

	@Override
	public List<UserBinding> getUserDetails() {
		List<UserBinding> bindingList = new ArrayList<>();
		List<UserEntityDetails> userList = detailsRepo.findAll();
		userList.forEach(user -> {
			UserBinding binding = new UserBinding();
			BeanUtils.copyProperties(user, binding);
			bindingList.add(binding);
		});

		return bindingList;
	}

	@Override
	public UserBinding getCity(String msg) {
		UserBinding binding = new UserBinding();
		UserEntityDetails userEntityDetails = detailsRepo.findByCity(msg);
		BeanUtils.copyProperties(userEntityDetails, binding);

		return binding;
	}

}
