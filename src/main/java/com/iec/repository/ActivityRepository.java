package com.iec.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.iec.entity.ActivityEntity;

public interface ActivityRepository extends MongoRepository<ActivityEntity, String>{
	
//	@Query("{ 'title' : {$regex: ?0, $options: 'i' }}")
	Optional<ActivityEntity> findActivityByTitle(final String title);
	
	Optional<ActivityEntity> findActivityById(final String id);

}