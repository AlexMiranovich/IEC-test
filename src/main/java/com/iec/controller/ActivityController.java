package com.iec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iec.entity.ActivityEntity;
import com.iec.exception.ActivityException;
import com.iec.service.ActivityServiceImpl;

@RestController
@RequestMapping("/activity")
public class ActivityController {
	
	@Autowired
	private ActivityServiceImpl activityServiceImpl;
	
 //   @ResponseStatus(value = HttpStatus.CREATED)
//	@GetMapping(path = "/getAllActivities", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @GetMapping(path = "/getAllActivities")
    @ResponseBody
    public List<ActivityEntity> getAllActivities() {
        return activityServiceImpl.getActivities();
    }
    
    @PostMapping(path = "/saveNewActivity", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String saveNewActivity(ActivityEntity activityEntity) throws ActivityException {
        return activityServiceImpl.saveActivity(activityEntity);
    }
    
    
    @PostMapping(path = "/updateExistActivity", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String updateExistActivity(ActivityEntity activityEntity)  {
 //       return activityServiceImpl.saveActivity(activityEntity);
    	return null;
    }
    
    
    
    
    
    @DeleteMapping(path = "/deleteActivity", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String deleteActivity(ActivityEntity activityEntity) {
        return activityServiceImpl.deleteActivity(activityEntity);
    }

}
