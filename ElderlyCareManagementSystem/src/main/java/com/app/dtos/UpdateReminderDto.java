package com.app.dtos;

import java.util.Date;

import com.app.entities.ReminderStatus;

public class UpdateReminderDto {

	private Integer reminderId;
	private String reminderTitle;
	private String reminderDesc;
	private Date reminderForDateTime;
	private ReminderStatus reminderStatus;
	
	public UpdateReminderDto() {
		// TODO Auto-generated constructor stub
	}
	public Integer getReminderId() {
		return reminderId;
	}
	public void setReminderId(Integer reminderId) {
		this.reminderId = reminderId;
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
	public UpdateReminderDto(Integer reminderId, String reminderTitle, String reminderDesc, Date reminderForDateTime,
			ReminderStatus reminderStatus) {
		super();
		this.reminderId = reminderId;
		this.reminderTitle = reminderTitle;
		this.reminderDesc = reminderDesc;
		this.reminderForDateTime = reminderForDateTime;
		this.reminderStatus = reminderStatus;
	}
	public void setReminderForDateTime(Date reminderForDateTime) {
		this.reminderForDateTime = reminderForDateTime;
	}
	public ReminderStatus getReminderStatus() {
		return reminderStatus;
	}
	public void setReminderStatus(ReminderStatus reminderStatus) {
		this.reminderStatus = reminderStatus;
	}
}
