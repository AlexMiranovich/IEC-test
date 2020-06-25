package com.iec.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iec.entity.ChangesEntity;

public interface ChangesRepository extends MongoRepository<ChangesEntity, String>{
	
}
