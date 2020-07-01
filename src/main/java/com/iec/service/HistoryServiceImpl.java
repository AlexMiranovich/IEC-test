package com.iec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iec.constants.MessageConstants;
import com.iec.entity.History;
import com.iec.exception.HistoryException;
import com.iec.repository.HistoryRepository;

@Service
public class HistoryServiceImpl implements HistoryService{
	
	@Autowired
	private HistoryRepository historyRepository;
	
	@Override
	public List<History> getHistories(){
		return historyRepository.findAll();
	}
	
	@Override
	public String saveHistory(History historyEntity) throws HistoryException{
		Optional<History> historyDB = historyRepository.findHistoryByDateTime(historyEntity.getDateTime());
		if(!historyDB.isEmpty()) {
			 throw new HistoryException(MessageConstants.HISTORY_ALREDY_EXISTS);
		};
		historyRepository.insert(historyEntity);
		
		return  MessageConstants.HISTORY_ADDED_SUCCESSFULLY;
	}

	@Override
	public String deleteHistory(History historyEntity) {
		historyRepository.delete(historyEntity);
		return MessageConstants.HISTORY_DELETED_SUCCESSFULLY;
	}
	
	@Override
	public String deleteHistoryByActivityId(String activityId) {
		historyRepository.deleteById(activityId);
		return MessageConstants.HISTORY_DELETED_SUCCESSFULLY;
	}

}
