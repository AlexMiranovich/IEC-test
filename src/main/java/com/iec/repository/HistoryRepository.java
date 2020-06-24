package com.iec.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iec.entity.HistoryEntity;

public interface HistoryRepository extends MongoRepository<HistoryEntity, String>{

}
