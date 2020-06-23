package com.iec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iec.entity.ActivityEntity;
import com.iec.service.ActivityServiceImpl;

@RestController
@RequestMapping("/activity")
public class ActivityController {
	
	@Autowired
	private ActivityServiceImpl activityServiceImpl;
	
	
 //   @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.GET, path = "/getAllActivities", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<ActivityEntity> getAllActivities() {
        return activityServiceImpl.getActivities();
    }

}
