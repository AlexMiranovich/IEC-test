package com.iec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iec.entity.Changes;
import com.iec.repository.ChangesRepository;


@Service
public class ChangesServiceImpl implements ChangesService{
	
	private ChangesRepository changesRepository;
	
	@Autowired
	public ChangesServiceImpl(ChangesRepository changesRepository) {
		this.changesRepository = changesRepository;
	}
	
	@Override
	public List<Changes> getChanges(){
		return changesRepository.findAll();
	}
	
	@Override
	public void deleteChanges(Changes changesEntity){
		changesRepository.delete(changesEntity);
	}

}