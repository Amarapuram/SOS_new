package com.SOS.controller;

import com.SOS.domain.SosDetails;
import com.SOS.service.EmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/emergencyDetails")
public class EmergencyController {
    @Autowired
    private final EmergencyService emergencyService;

    public EmergencyController(EmergencyService emergencyService) {
        this.emergencyService = emergencyService;
    }
    //changes to be made
    @GetMapping("/{id}")
    public ResponseEntity<Optional<SosDetails>> getSosDetailsById(@PathVariable String userID){
        return ResponseEntity.ok(emergencyService.getSosDetailsByUserId(userID));
    }

}
