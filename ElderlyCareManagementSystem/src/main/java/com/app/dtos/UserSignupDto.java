package com.app.dtos;

public class UserSignupDto {
	private String userName;
	private String password;
	private Integer userAge;
	
	public UserSignupDto() {
		// TODO Auto-generated constructor stub
	}
	public UserSignupDto(String userName, String password, Integer userAge) {
		super();
		this.userName = userName;
		this.password = password;
		this.userAge = userAge;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUserAge() {
		return userAge;
	}
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
}
