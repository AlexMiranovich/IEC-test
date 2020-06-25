package com.iec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iec.constants.MessageConstants;
import com.iec.entity.ChangesEntity;
import com.iec.repository.ChangesRepository;


@Service
public class ChangesServiceImpl implements ChangesService{
	
	@Autowired
	private ChangesRepository changesRepository;
	
	@Override
	public List<ChangesEntity> getChanges(){
		return changesRepository.findAll();
	}
	
	@Override
	public String deleteChanges(ChangesEntity changesEntity){
		changesRepository.delete(changesEntity);
		return  MessageConstants.CHANGES_DELETED_SUCCESSFULLY;
	}

}