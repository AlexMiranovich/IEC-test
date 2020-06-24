package com.iec.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iec.entity.HistoryEntity;

public interface HistoryRepository extends MongoRepository<HistoryEntity, String>{

	Optional<HistoryEntity> findHistoryByDateTime(final Date dateTime);
	
}
