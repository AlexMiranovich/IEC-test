package com.iec.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iec.entity.ChangesEntity;

public interface ChangesRepository extends MongoRepository<ChangesEntity, String>{
	
}
