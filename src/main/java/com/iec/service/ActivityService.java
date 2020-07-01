package com.iec.service;

import java.util.List;

import com.iec.entity.Activity;
import com.iec.exception.ActivityException;
import com.iec.exception.HistoryException;

public interface ActivityService {
	
	List<Activity> getActivities();
		
	String deleteActivity(Activity activityEntity);
	
	String saveActivity(Activity activityEntity) throws ActivityException, HistoryException;
	
	String updateActivity(Activity activityEntity) throws ActivityException, HistoryException;

}