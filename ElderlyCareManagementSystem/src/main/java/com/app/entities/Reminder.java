package com.app.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="reminders")
public class Reminder implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="reminder_id")
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reminderId;

	@Column(name="reminder_title")
	private String reminderTitle;
	
	@Column(name="reminder_desc")
	private String reminderDesc;
	
	@Column(name="reminder_creation_date")
	@Temporal(TemporalType.DATE)
	@UpdateTimestamp
	private Date reminderCreationDate;
	
	@Column(name="reminder_for_date_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reminderForDateTime;
	
	@Enumerated(EnumType.STRING)
	@Column(name="reminder_status")
	private ReminderStatus reminderStatus;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@JsonIgnore
	private User user;

	public Reminder() {
		// TODO Auto-generated constructor stub
	}
	public Reminder(Integer reminderId, String reminderTitle, String reminderDesc, Date reminderCreationDate,
			Date reminderForDateTime, ReminderStatus reminderStatus, User user) {
		super();
		this.reminderId = reminderId;
		this.reminderTitle = reminderTitle;
		this.reminderDesc = reminderDesc;
		this.reminderCreationDate = reminderCreationDate;
		this.reminderForDateTime = reminderForDateTime;
		this.reminderStatus = reminderStatus;
		this.user = user;
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

	public Date getReminderCreationDate() {
		return reminderCreationDate;
	}

	public void setReminderCreationDate(Date reminderCreationDate) {
		this.reminderCreationDate = reminderCreationDate;
	}

	public Date getReminderForDateTime() {
		return reminderForDateTime;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
