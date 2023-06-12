package com.app.dtos;

import java.util.Date;

public class NewReminderDto {
	private Integer reminderId;
	public Integer getReminderId() {
		return reminderId;
	}
	public void setReminderId(Integer reminderId) {
		this.reminderId = reminderId;
	}
	private String reminderTitle;
	private String reminderDesc;
	private Date reminderForDateTime;
	private Integer userId;
	
	public NewReminderDto() {
		// TODO Auto-generated constructor stub
	}
	public String getReminderTitle() {
		return reminderTitle;
	}
	public void setReminderTitle(String reminderTitle) {
		this.reminderTitle = reminderTitle;
	}
	public String getReminderDesc() {
		return reminderDesc;
	}
	public void setReminderDesc(String reminderDesc) {
		this.reminderDesc = reminderDesc;
	}
	public Date getReminderForDateTime() {
		return reminderForDateTime;
	}
	public void setReminderForDateTime(Date reminderForDateTime) {
		this.reminderForDateTime = reminderForDateTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public NewReminderDto(Integer reminderId, String reminderTitle, String reminderDesc, Date reminderForDateTime,
			Integer userId) {
		super();
		this.reminderId = reminderId;
		this.reminderTitle = reminderTitle;
		this.reminderDesc = reminderDesc;
		this.reminderForDateTime = reminderForDateTime;
		this.userId = userId;
	}
	
}
