//package com.SOS.controller;
//
//import com.SOS.domain.ApiResponse;
//import com.SOS.service.SOSService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class ApiController {
//
//    @Autowired
//    private SOSService sosService;
//
//    @GetMapping("/nearby-hospitals")
//    public ApiResponse getNearbyHospitals(@RequestParam double lat, @RequestParam double lon) {
//        return sosService.getNearbyHospitals(lat, lon);
//    }
//
//    @GetMapping("/nearby-fire-stations")
//    public ApiResponse getNearbyFireStations(@RequestParam double lat, @RequestParam double lon) {
//        return sosService.getNearbyFireStations(lat, lon);
//    }
//
//    @GetMapping("/nearby-police-stations")
//    public ApiResponse getNearbyPoliceStations(@RequestParam double lat, @RequestParam double lon) {
//        return sosService.getNearbyPoliceStations(lat, lon);
//    }
//}

package com.SOS.controller;

import com.SOS.dto.FireStationDTO;
import com.SOS.dto.HospitalDTO;
import com.SOS.dto.PoliceStationDTO;
import com.SOS.service.SOSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private SOSService sosService;

    @GetMapping("/nearby-hospitals")
    public List<HospitalDTO> getNearbyHospitals(@RequestParam double lat, @RequestParam double lon) {
        return sosService.getNearbyHospitals(lat, lon);
    }

    @GetMapping("/nearby-fire-stations")
    public List<FireStationDTO> getNearbyFireStations(@RequestParam double lat, @RequestParam double lon) {
        return sosService.getNearbyFireStations(lat, lon);
    }

    @GetMapping("/nearby-police-stations")
    public List<PoliceStationDTO> getNearbyPoliceStations(@RequestParam double lat, @RequestParam double lon) {
        return sosService.getNearbyPoliceStations(lat, lon);
    }
}

