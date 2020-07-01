package com.iec.service;

import java.util.List;

import com.iec.entity.Activity;
import com.iec.exception.ActivityException;
import com.iec.exception.HistoryException;

public interface ActivityService {
	
	List<Activity> getActivities();
		
	void deleteActivity(Activity activityEntity);
	
	void saveActivity(Activity activityEntity) throws ActivityException, HistoryException;
	
	void updateActivity(Activity activityEntity) throws ActivityException, HistoryException;

}