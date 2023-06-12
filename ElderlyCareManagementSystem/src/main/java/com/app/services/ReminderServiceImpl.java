package com.app.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dtos.NewReminderDto;
import com.app.dtos.ResponseStatusDto;
import com.app.dtos.UpdateReminderDto;
import com.app.entities.Reminder;
import com.app.entities.ReminderStatus;
import com.app.entities.User;
import com.app.repositories.ReminderRepository;
import com.app.repositories.UserRepository;

@Service
@Transactional
public class ReminderServiceImpl implements ReminderService{
	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	ReminderRepository reminderRepository;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public List<Reminder> getAllRemindersByUserId(Integer userid) {
		return reminderRepository.findAllByUserUserId(userid);
	}

	@Override
	public Reminder getReminderById(Integer reminderid) {
		return reminderRepository.findById(reminderid).orElseThrow();
	}

	@Override
	public ResponseStatusDto deleteReminder(Integer reminderid) {
		ResponseStatusDto status = new ResponseStatusDto();
		Reminder reminder = reminderRepository.findById(reminderid).orElseThrow();
		
		try {
			reminderRepository.delete(reminder);
			status.setStatusCode(200);
			status.setStatus("Reminder deleted successfully.");
			status.setReminder(reminder);
		}catch (Exception e) {
			status.setStatusCode(501);
			status.setStatus("Exception occured while deleting reminder.");
		}
		return status;
	}

	@Override
	public ResponseStatusDto addReminder(NewReminderDto newReminderDto) {
		ResponseStatusDto status = new ResponseStatusDto();
		Reminder newReminderEntity = mapper.map(newReminderDto, Reminder.class);
		User user = userRepository.findById(newReminderDto.getUserId()).orElseThrow();
		
		newReminderEntity.setUser(user);
		newReminderEntity.setReminderStatus(ReminderStatus.PENDING);
		
		try {
			reminderRepository.save(newReminderEntity);
			status.setStatusCode(200);
			status.setStatus("Reminder saved successfully.");
			status.setReminder(newReminderEntity);
		}
		catch (Exception e) {
			status.setStatusCode(501);
			status.setStatus("Exception occured while saving reminder.");
		}
		
		return status;
	}

	@Override
	public ResponseStatusDto updateReminder(UpdateReminderDto updatedReminderDto) {
		ResponseStatusDto status = new ResponseStatusDto();
		Reminder existingReminderEntity = reminderRepository.findById(updatedReminderDto.getReminderId()).orElseThrow();
		
		existingReminderEntity.setReminderTitle(updatedReminderDto.getReminderTitle());
		existingReminderEntity.setReminderDesc(updatedReminderDto.getReminderDesc());
		existingReminderEntity.setReminderForDateTime(updatedReminderDto.getReminderForDateTime());
		existingReminderEntity.setReminderStatus(updatedReminderDto.getReminderStatus());
		
		try {
			reminderRepository.save(existingReminderEntity);
			status.setStatusCode(200);
			status.setStatus("Reminder updated successfully.");
			status.setReminder(existingReminderEntity);
		}
		catch (Exception e) {
			status.setStatusCode(501);
			status.setStatus("Exception occured while saving reminder.");
		}
		
		return status;
	}

}
