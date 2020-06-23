package com.iec.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.iec.entity.ActivityEntity;

public interface ActivityRepository extends MongoRepository<ActivityEntity, String>{
	
	@Query("{ 'title' : {$regex: ?0, $options: 'i' }}")
	ActivityEntity findActivityByTitle(final String title);
	
	@Query("{ 'id' : {$regex: ?0 }}")
	ActivityEntity findActivityById(final ObjectId objectId);

}
