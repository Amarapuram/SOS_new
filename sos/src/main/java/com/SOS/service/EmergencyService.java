package com.SOS.service;

import com.SOS.domain.SosDetails;
import com.SOS.repository.EmergencyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmergencyService {

    private final EmergencyRepository emergencyRepository;

    public EmergencyService(EmergencyRepository emergencyRepository) {
        this.emergencyRepository = emergencyRepository;
    }

    public Optional<SosDetails> getSosDetailsByUserId(String userID){
        return emergencyRepository.findById(userID);
    }

    public SosDetails saveSosDetails(SosDetails sosDetails){
        return emergencyRepository.save(sosDetails);
    }
}
