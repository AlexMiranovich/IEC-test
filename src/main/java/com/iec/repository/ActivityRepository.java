package com.iec.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iec.entity.ActivityEntity;

public interface ActivityRepository extends MongoRepository<ActivityEntity, String>{
	
	Optional<ActivityEntity> findActivityByTitle(final String title);
	
	Optional<ActivityEntity> findActivityById(final String id);

}