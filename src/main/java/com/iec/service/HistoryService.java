package com.iec.service;

import java.util.List;

import com.iec.entity.History;
import com.iec.exception.HistoryException;

public interface HistoryService {
	
	List<History> getHistories();
	
	String saveHistory(History historyEntity) throws HistoryException;
	
	void deleteHistory(History historyEntity);

	void deleteHistoryByActivityId(String activityId);
		
}
