package com.app.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class User {
	@Column(name="user_id")
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(name="user_name", unique = true)
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="user_age")
	private Integer userAge;
	
	@OneToMany(mappedBy = "user", fetch=FetchType.EAGER)
	private List<Reminder> reminders;
	 
	@Column(name="user_cretion_date")
	@Temporal(TemporalType.DATE)
	@UpdateTimestamp
	private Date userCreationDate;

	public User() {
		super();
	}

	public User(Integer userId, String userName, String password, Integer userAge, List<Reminder> reminders,
			Date userCreationDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userAge = userAge;
		this.reminders = reminders;
		this.userCreationDate = userCreationDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public List<Reminder> getReminders() {
		return reminders;
	}

	public void setReminders(List<Reminder> reminders) {
		this.reminders = reminders;
	}

	public Date getUserCreationDate() {
		return userCreationDate;
	}

	public void setUserCreationDate(Date userCreationDate) {
		this.userCreationDate = userCreationDate;
	}
	
}