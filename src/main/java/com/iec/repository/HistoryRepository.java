package com.iec.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iec.entity.History;

public interface HistoryRepository extends MongoRepository<History, String>{

	Optional<History> findHistoryByDateTime(final Date dateTime);
	
}
