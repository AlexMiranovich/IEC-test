package com.iec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iec.entity.HistoryEntity;
import com.iec.exception.HistoryException;
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
    
    @DeleteMapping(path = "/deleteHistory", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteHistory(@RequestBody HistoryEntity historyEntity) {
    	return historyServiceImpl.deleteHistory(historyEntity);     		
    }
    
    @PostMapping(path = "/saveNewHistory", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveNewHistory(@RequestBody HistoryEntity historyEntity) throws HistoryException{
        return historyServiceImpl.saveHistory(historyEntity);
    }
    
}