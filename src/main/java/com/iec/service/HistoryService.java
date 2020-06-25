package com.iec.service;

import java.util.List;

import com.iec.entity.HistoryEntity;
import com.iec.exception.HistoryException;

public interface HistoryService {
	
	List<HistoryEntity> getHistories();
	
	String saveHistory(HistoryEntity historyEntity) throws HistoryException;
	
	String deleteHistory(HistoryEntity historyEntity);

	String deleteHistoryByActivityId(String activityId);
		
}
