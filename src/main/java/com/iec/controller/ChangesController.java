package com.iec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iec.entity.ChangesEntity;
import com.iec.service.ChangesServiceImpl;

@RestController
@RequestMapping("/changes")
public class ChangesController {
	
	@Autowired
	private ChangesServiceImpl changesServiceImpl;
	
    @GetMapping(path = "/getAllChanges")
    @ResponseBody
    public List<ChangesEntity> getAllChanges() {
        return changesServiceImpl.getChanges();
    }
    
    @DeleteMapping(path = "/deleteChanges", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteChanges(@RequestBody ChangesEntity changesEntity) {
    	return changesServiceImpl.deleteChanges(changesEntity);     		
    }
      
}