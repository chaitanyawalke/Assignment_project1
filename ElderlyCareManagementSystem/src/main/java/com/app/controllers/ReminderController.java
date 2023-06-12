package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.NewReminderDto;
import com.app.dtos.ResponseStatusDto;
import com.app.dtos.UpdateReminderDto;
import com.app.entities.Reminder;
import com.app.services.ReminderService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/reminder")
public class ReminderController {

	@Autowired
	ReminderService reminderService;
	
	@PostMapping("/getAllRemindersByUserId")
	public List<Reminder> getAllReminders(@RequestBody Integer userid){	
		return reminderService.getAllRemindersByUserId(userid);
	}
	
	@PostMapping("/getReminderByReminderId")
	public Reminder getReminderByReminderId(@RequestBody Integer reminderid){	
		return reminderService.getReminderById(reminderid);
	}
	
	@PostMapping("/addReminder")
	public ResponseStatusDto addReminder(@RequestBody NewReminderDto newReminder){
		return reminderService.addReminder(newReminder);
	}
	
	@PostMapping("/updateReminder")
	public ResponseStatusDto updateReminder(@RequestBody UpdateReminderDto updatedReminder){
		return reminderService.updateReminder(updatedReminder);
	}
	
	@PostMapping("/deleteReminder")
	public ResponseStatusDto deleteReminder(@RequestBody Integer reminderid){
		return reminderService.deleteReminder(reminderid);
	}
}
