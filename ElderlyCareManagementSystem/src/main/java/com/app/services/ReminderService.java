package com.app.services;

import java.util.List;

import com.app.dtos.NewReminderDto;
import com.app.dtos.ResponseStatusDto;
import com.app.dtos.UpdateReminderDto;
import com.app.entities.Reminder;

public interface ReminderService {
	List<Reminder> getAllRemindersByUserId(Integer userid);
	Reminder getReminderById(Integer reminderid);
	ResponseStatusDto deleteReminder(Integer reminderid);
	ResponseStatusDto addReminder(NewReminderDto newReminder);
	ResponseStatusDto updateReminder(UpdateReminderDto updatedReminder);
}
