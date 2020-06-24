package com.iec.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.iec.entity.HistoryEntity;

public interface HistoryRepository extends MongoRepository<HistoryEntity, String>{
/*	
	@Query("{ 'id' : {$regex: ?0 }}")
	void deleteHistory(String activityId);
*/
}
