package com.iec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iec.entity.HistoryEntity;
import com.iec.repository.HistoryRepository;

@Service
public class HistoryServiceImpl implements HistoryService{
	
	@Autowired
	private HistoryRepository historyRepository;
	
	@Override
	public List<HistoryEntity> getHistories(){
		return historyRepository.findAll();
	}
	
	@Override
	public void saveHistory(HistoryEntity historyEntity){
		historyRepository.insert(historyEntity);
	}
/*	
	@Override
	public void deleteHistory(String activityId) {
		historyRepository.deleteHistoryByActivityId(activityId);
	}
*/
}
