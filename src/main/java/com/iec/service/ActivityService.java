package com.iec.service;

import java.util.List;

import com.iec.entity.ActivityEntity;
import com.iec.exception.ActivityException;

public interface ActivityService {
	
	List<ActivityEntity> getActivities();
	
	String deleteActivity(ActivityEntity activityEntity);
	
	String saveActivity(ActivityEntity activityEntity) throws ActivityException;
	
	String updateActivity(ActivityEntity activityEntity);

}