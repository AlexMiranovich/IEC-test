package com.iec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iec.entity.Activity;
import com.iec.exception.ActivityException;
import com.iec.exception.HistoryException;
import com.iec.service.ActivityService;

@RestController
@RequestMapping("/activity")
public class ActivityController {
	
	private ActivityService activityService;
	
	@Autowired
	public ActivityController(ActivityService activityService) {
		this.activityService = activityService;
	}
	
    @GetMapping("/get-activities")
    public List<Activity> getAllActivities() {
    	return activityService.getActivities();
    }
    
    @PostMapping("/save-activity")
    public String saveNewActivity(@RequestBody Activity activityEntity) throws ActivityException, HistoryException {
        return activityService.saveActivity(activityEntity);
    }
    
    @DeleteMapping("/delete-activity")
    public String deleteActivity(@RequestBody Activity activityEntity) {
    	return activityService.deleteActivity(activityEntity);     		
    }
        
    @PutMapping("/update-activity")
    public String updateExistActivity(@RequestBody Activity activityEntity) throws ActivityException, HistoryException  {
    	return activityService.updateActivity(activityEntity); 
    }
    
}