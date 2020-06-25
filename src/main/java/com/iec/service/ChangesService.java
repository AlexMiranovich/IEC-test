package com.iec.service;

import java.util.List;

import com.iec.entity.ChangesEntity;

public interface ChangesService {
	
	List<ChangesEntity> getChanges();
	
	String deleteChanges(ChangesEntity changesEntity);
		
}