package com.iec.service;

import java.util.List;

import com.iec.entity.Changes;

public interface ChangesService {
	
	List<Changes> getChanges();
	
	String deleteChanges(Changes changesEntity);
		
}