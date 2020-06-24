package com.iec.service;

import java.util.List;

import com.iec.entity.HistoryEntity;

public interface HistoryService {
	
	List<HistoryEntity> getHistories();
	
	void saveHistory(HistoryEntity historyEntity);
	
}
