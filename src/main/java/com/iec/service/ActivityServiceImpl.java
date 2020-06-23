package com.iec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iec.entity.ActivityEntity;
import com.iec.repository.ActivityRepository;

@Service
public class ActivityServiceImpl {
	
	@Autowired
	private ActivityRepository activityRepository;
	
	public List<ActivityEntity> getActivities(){
		return activityRepository.findAll();
	}
	
	public boolean savetActivitie(ActivityEntity activityEntity){
		
		ActivityEntity activity = activityRepository.findByTitle(activityEntity.getTitle());
		if(activity != null) {
			 throw new ActivityException(ErrorMessages.MEMBER_ALREDY_EXISTS);
		}
		
		activityRepository.insert(activityEntity);
		return  true;
	}

}
