package com.iec.service;

import java.util.List;

import com.iec.entity.ActivityEntity;
import com.iec.exception.ActivityException;
import com.iec.exception.HistoryException;

public interface ActivityService {
	
	List<ActivityEntity> getActivities();
		
	String deleteActivity(ActivityEntity activityEntity);
	
	String saveActivity(ActivityEntity activityEntity) throws ActivityException, HistoryException;
	
	String updateActivity(ActivityEntity activityEntity) throws ActivityException, HistoryException;

}