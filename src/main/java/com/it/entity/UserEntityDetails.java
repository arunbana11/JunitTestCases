package com.it.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserEntityDetails {

	@Id
	@GeneratedValue
	private Integer userId;
	private String userName;
	private String city;
	private Double salary;
	private String email;
	private String pwd;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public UserEntityDetails(Integer userId, String userName, String city, Double salary, String email, String pwd) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.city = city;
		this.salary = salary;
		this.email = email;
		this.pwd = pwd;
	}
	public UserEntityDetails() {
		super();
	}
	
	
	
}
