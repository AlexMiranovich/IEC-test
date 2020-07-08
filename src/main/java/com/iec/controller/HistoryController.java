package com.iec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iec.entity.History;
import com.iec.exception.HistoryException;
import com.iec.service.HistoryService;

@RestController
@RequestMapping("/history")
public class HistoryController {
	
	private HistoryService historyService;
	
	public HistoryController(HistoryService historyService) {
		this.historyService = historyService;
	}
	
    @GetMapping("/get")
    public List<History> getAllHistory() {
    	return historyService.getHistories();
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<History> deleteHistory(@RequestBody History historyEntity) {
    	historyService.deleteHistory(historyEntity);   
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/save")
    public ResponseEntity<History> saveNewHistory(@RequestBody History historyEntity) throws HistoryException{
        historyService.saveHistory(historyEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}