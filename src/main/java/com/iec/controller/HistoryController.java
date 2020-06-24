package com.iec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iec.entity.HistoryEntity;
import com.iec.service.HistoryServiceImpl;

@RestController
@RequestMapping("/history")
public class HistoryController {
	
	@Autowired
	private HistoryServiceImpl historyServiceImpl;
	
    @GetMapping(path = "/getAllHistory")
    @ResponseBody
    public List<HistoryEntity> getAllHistory() {
        return historyServiceImpl.getHistories();
    }
    
 /*   
    @PostMapping(path = "/saveNewHistory", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveNewActivity(@RequestBody ActivityEntity activityEntity) throws ActivityException {
        return activityServiceImpl.saveActivity(activityEntity);
    }
    
    @DeleteMapping(path = "/deleteHistory", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteActivity(@RequestBody ActivityEntity activityEntity) {
    	return activityServiceImpl.deleteActivity(activityEntity);     		
    }
        
    @PostMapping(path = "/updateExistActivity", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String updateExistActivity(@RequestBody ActivityEntity activityEntity)  {
 //       return activityServiceImpl.saveActivity(activityEntity);
    	return null;
    }
*/ 
    
}