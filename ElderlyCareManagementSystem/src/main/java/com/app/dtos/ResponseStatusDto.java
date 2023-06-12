package com.app.dtos;

import com.app.entities.Reminder;
import com.app.entities.User;

public class ResponseStatusDto {
	private Integer statusCode;
	private String status;
	private User user;
	private Reminder reminder;
	
	
	public ResponseStatusDto(Integer statusCode, String status, User user, Reminder reminder) {
		super();
		this.statusCode = statusCode;
		this.status = status;
		this.user = user;
		this.reminder = reminder;
	}
	public Reminder getReminder() {
		return reminder;
	}
	public void setReminder(Reminder reminder) {
		this.reminder = reminder;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ResponseStatusDto() {
		// TODO Auto-generated constructor stub
	}
}