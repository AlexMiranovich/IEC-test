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
	
	private HistoryRepository historyRepository;
	
	public HistoryServiceImpl(HistoryRepository historyRepository) {
		this.historyRepository = historyRepository;
	}
	
	@Override
	public List<History> getHistories(){
		return historyRepository.findAll();
	}
	
	@Override
	public String saveHistory(History history) throws HistoryException{
		Optional<History> historyDB = historyRepository.findHistoryByDateTime(history.getDateTime());
		if(historyDB.isPresent()) {
			 throw new HistoryException(MessageConstants.HISTORY_ALREDY_EXISTS);
		}
		historyRepository.insert(history);
		return  MessageConstants.HISTORY_ADDED_SUCCESSFULLY;
	}

	@Override
	public void deleteHistory(History history) {
		historyRepository.delete(history);
	}
	
	@Override
	public void deleteHistoryByActivityId(String activityId) {
		historyRepository.deleteById(activityId);
	}

}
