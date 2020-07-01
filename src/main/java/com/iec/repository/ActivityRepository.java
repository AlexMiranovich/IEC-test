package com.iec.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iec.entity.Activity;

public interface ActivityRepository extends MongoRepository<Activity, String>{
	
	Optional<Activity> findActivityByTitle(final String title);
	
	Optional<Activity> findActivityById(final String id);

}