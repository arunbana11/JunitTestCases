package com.it.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it.entity.UserEntityDetails;

public interface UserDetailsRepo extends JpaRepository<UserEntityDetails, Integer> {

	UserEntityDetails findByCity(String city);
	
	
}
