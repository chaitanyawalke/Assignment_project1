package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Reminder;

public interface ReminderRepository extends JpaRepository<Reminder, Integer>{

	public List<Reminder> findAllByUserUserId(Integer userid);
}