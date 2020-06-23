package com.iec.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.iec.entity.ActivityEntity;

public interface ActivityRepository extends MongoRepository<ActivityEntity, String>{
	
	@Query("{ 'title' : {$regex: ?0, $options: 'i' }}")
	public ActivityEntity findByTitle(final String title);

}
