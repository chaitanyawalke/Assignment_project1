package com.app.dtos;

public class LoginRequestDto {
	private String userName;
	private String password;
	
	public LoginRequestDto() {
		// TODO Auto-generated constructor stub
	}
	public LoginRequestDto(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
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
	
	
}
