package com.SOS.repository;

import com.SOS.domain.SosDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmergencyRepository extends MongoRepository<SosDetails,String> {

}
