package com.iec.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iec.entity.Changes;

public interface ChangesRepository extends MongoRepository<Changes, String>{
	
}
