package com.iec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	public HistoryController(HistoryService historyService) {
		this.historyService = historyService;
	}
	
    @GetMapping("/get-history")
    public List<History> getAllHistory() {
    	return historyService.getHistories();
    }
    
    @DeleteMapping("/delete-history")
    public String deleteHistory(@RequestBody History historyEntity) {
    	return historyService.deleteHistory(historyEntity);     		
    }
    
    @PostMapping("/save-history")
    public String saveNewHistory(@RequestBody History historyEntity) throws HistoryException{
        return historyService.saveHistory(historyEntity);
    }
    
}