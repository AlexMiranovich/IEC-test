package com.iec.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	private final ActivityService activityService;
	
	public ActivityController(ActivityService activityService) {
		this.activityService = activityService;
	}
	
    @GetMapping("/get")
    public List<Activity> getAllActivities() {
    	return activityService.getActivities();
    }
    
    @PostMapping("/save")
    public ResponseEntity<Activity> saveNewActivity(@RequestBody Activity activityEntity) throws ActivityException, HistoryException {
        activityService.saveActivity(activityEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<Activity> deleteActivity(@RequestBody Activity activityEntity) {
    	activityService.deleteActivity(activityEntity); 
    	return new ResponseEntity<>(HttpStatus.OK);
    }
        
    @PutMapping("/update")
    public ResponseEntity<Activity> updateExistActivity(@RequestBody Activity activityEntity) throws ActivityException, HistoryException  {
    	activityService.updateActivity(activityEntity); 
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
}