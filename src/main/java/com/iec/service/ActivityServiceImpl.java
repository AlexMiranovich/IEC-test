package com.iec.service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iec.constants.MessageConstants;
import com.iec.entity.ActivityEntity;
import com.iec.exception.ActivityException;
import com.iec.repository.ActivityRepository;

@Service
public class ActivityServiceImpl {
	
	@Autowired
	private ActivityRepository activityRepository;
	
	public List<ActivityEntity> getActivities(){
		return activityRepository.findAll();
	}
	
	public String saveActivity(ActivityEntity activityEntity) throws ActivityException{
		ActivityEntity activity = activityRepository.findActivityByTitle(activityEntity.getTitle());
		if(activity != null) {
			 throw new ActivityException(MessageConstants.ACTIVITY_ALREDY_EXISTS);
		}
		activityRepository.insert(activityEntity);
		return  MessageConstants.ACTIVITY_ADDED_SUCCESSFULLY;
	}
	
	public String updateActivity(ActivityEntity activityEntity){
		ActivityEntity activity = activityRepository.findActivityById(activityEntity.getId());
		Map<String, String> oldOdject = new HashMap<>();
		

		return  MessageConstants.ACTIVITY_UPDATED_SUCCESSFULLY;
	}
	
	public String deleteActivity(ActivityEntity activityEntity){
		activityRepository.delete(activityEntity);
		return MessageConstants.ACTIVITY_DELETED_SUCCESSFULLY;
	}

}