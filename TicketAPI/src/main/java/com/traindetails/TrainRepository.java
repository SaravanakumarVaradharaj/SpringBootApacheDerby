package com.traindetails;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TrainRepository extends CrudRepository<TrainDetails, String>{
public List<TrainDetails> findByTrid(String id);
}
