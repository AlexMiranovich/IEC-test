package com.iec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iec.entity.Changes;
import com.iec.service.ChangesService;

@RestController
@RequestMapping("/changes")
public class ChangesController {
	
	private ChangesService changesService;
	
	@Autowired
	public ChangesController(ChangesService changesService) {
		this.changesService = changesService;
	}
	
    @GetMapping("/get-changes")
    public List<Changes> getAllChanges() {
        return changesService.getChanges();
    }
    
    @DeleteMapping("/delete-changes")
    public String deleteChanges(@RequestBody Changes changesEntity) {
    	return changesService.deleteChanges(changesEntity);     		
    }
      
}