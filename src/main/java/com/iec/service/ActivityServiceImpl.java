package com.iec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iec.constants.MessageConstants;
import com.iec.entity.ActivityEntity;
import com.iec.exception.ActivityException;
import com.iec.repository.ActivityRepository;

@Service
public class ActivityServiceImpl implements ActivityService{
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Override
	public List<ActivityEntity> getActivities(){
		return activityRepository.findAll();
	}
	
	@Override
	public String saveActivity(ActivityEntity activityEntity) throws ActivityException{
		Optional<ActivityEntity> activity = activityRepository.findActivityByTitle(activityEntity.getTitle());
		if(!activity.isEmpty()) {
			 throw new ActivityException(MessageConstants.ACTIVITY_ALREDY_EXISTS);
		};
		activityRepository.insert(activityEntity);
		return  MessageConstants.ACTIVITY_ADDED_SUCCESSFULLY;
	}
	
	@Override
	public String deleteActivity(ActivityEntity activityEntity){
		activityRepository.delete(activityEntity);
		return  MessageConstants.ACTIVITY_DELETED_SUCCESSFULLY;
	}

	@Override
	public String updateActivity(ActivityEntity activityEntity){
		Optional<ActivityEntity> existActivity = activityRepository.findActivityById(activityEntity.getId());
		if(existActivity.isPresent()) {
//			existActivity.
			
		}
		
		
		
		
		
		
		
		
		

		return  MessageConstants.ACTIVITY_UPDATED_SUCCESSFULLY;
	}


	


}