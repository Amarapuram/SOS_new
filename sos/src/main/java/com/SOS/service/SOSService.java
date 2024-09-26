////package com.SOS.service;
////
////import com.SOS.domain.ApiResponse;
////import org.springframework.http.ResponseEntity;
////import org.springframework.stereotype.Service;
////import org.springframework.web.client.RestTemplate;
////
////@Service
////public class SOSService {
////
////    private final RestTemplate restTemplate = new RestTemplate();
////
////    public ApiResponse getNearbyHospitals(double lat, double lon) {
////        String query = "[out:json];node[\"amenity\"=\"hospital\"](around:5000," + lat + "," + lon + ");out;";
////        String url = "https://overpass-api.de/api/interpreter?data=" + query;
////
////        try {
////            ResponseEntity<ApiResponse> response = restTemplate.getForEntity(url, ApiResponse.class);
////            return response.getBody();
////        } catch (Exception e) {
////            e.printStackTrace(); // Log the exception for debugging
////            return null; // Or handle this as appropriate
////        }
////    }
////
////    public ApiResponse getNearbyFireStations(double lat, double lon) {
////        String query = "[out:json];node[\"amenity\"=\"fire_station\"](around:5000," + lat + "," + lon + ");out;";
////        String url = "https://overpass-api.de/api/interpreter?data=" + query;
////
////        try {
////            ResponseEntity<ApiResponse> response = restTemplate.getForEntity(url, ApiResponse.class);
////            return response.getBody();
////        } catch (Exception e) {
////            e.printStackTrace(); // Log the exception for debugging
////            return null; // Or handle this as appropriate
////        }
////    }
////
////    public ApiResponse getNearbyPoliceStations(double lat, double lon) {
////        String query = "[out:json];node[\"amenity\"=\"police\"](around:5000," + lat + "," + lon + ");out;";
////        String url = "https://overpass-api.de/api/interpreter?data=" + query;
////
////        try {
////            ResponseEntity<ApiResponse> response = restTemplate.getForEntity(url, ApiResponse.class);
////            return response.getBody();
////        } catch (Exception e) {
////            e.printStackTrace(); // Log the exception for debugging
////            return null; // Or handle this as appropriate
////        }
////    }
////}
////
//package com.SOS.service;
//
//import com.SOS.domain.ApiResponse;
//import com.SOS.dto.HospitalDTO;
//import com.SOS.dto.FireStationDTO;
//import com.SOS.dto.PoliceStationDTO;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class SOSService {
//
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    public List<HospitalDTO> getNearbyHospitals(double lat, double lon) {
//        String query = "[out:json];node[\"amenity\"=\"hospital\"](around:5000," + lat + "," + lon + ");out;";
//        String url = "https://overpass-api.de/api/interpreter?data=" + query;
//
//        try {
//            ResponseEntity<ApiResponse> response = restTemplate.getForEntity(url, ApiResponse.class);
//            return mapHospitals(response.getBody());
//        } catch (Exception e) {
//            e.printStackTrace(); // Log the exception for debugging
//            return null; // Or handle this as appropriate
//        }
//    }
//
//    public List<FireStationDTO> getNearbyFireStations(double lat, double lon) {
//        String query = "[out:json];node[\"amenity\"=\"fire_station\"](around:5000," + lat + "," + lon + ");out;";
//        String url = "https://overpass-api.de/api/interpreter?data=" + query;
//
//        try {
//            ResponseEntity<ApiResponse> response = restTemplate.getForEntity(url, ApiResponse.class);
//            return mapFireStations(response.getBody());
//        } catch (Exception e) {
//            e.printStackTrace(); // Log the exception for debugging
//            return null; // Or handle this as appropriate
//        }
//    }
//
//    public List<PoliceStationDTO> getNearbyPoliceStations(double lat, double lon) {
//        String query = "[out:json];node[\"amenity\"=\"police\"](around:5000," + lat + "," + lon + ");out;";
//        String url = "https://overpass-api.de/api/interpreter?data=" + query;
//
//        try {
//            ResponseEntity<ApiResponse> response = restTemplate.getForEntity(url, ApiResponse.class);
//            return mapPoliceStations(response.getBody());
//        } catch (Exception e) {
//            e.printStackTrace(); // Log the exception for debugging
//            return null; // Or handle this as appropriate
//        }
//    }
//
//    private List<HospitalDTO> mapHospitals(ApiResponse apiResponse) {
//        // Assuming apiResponse has a method to get the nodes
//        return apiResponse.getElements().stream()
//                .filter(element -> "hospital".equals(element.getAmenity())) // Adjust as per your ApiResponse structure
//                .map(element -> new HospitalDTO(element.getId(), element.getName(), element.getAddress())) // Map to DTO
//                .collect(Collectors.toList());
//    }
//
//    private List<FireStationDTO> mapFireStations(ApiResponse apiResponse) {
//        return apiResponse.getElements().stream()
//                .filter(element -> "fire_station".equals(element.getAmenity())) // Adjust as per your ApiResponse structure
//                .map(element -> new FireStationDTO(element.getId(), element.getName(), element.getAddress())) // Map to DTO
//                .collect(Collectors.toList());
//    }
//
//    private List<PoliceStationDTO> mapPoliceStations(ApiResponse apiResponse) {
//        return apiResponse.getElements().stream()
//                .filter(element -> "police".equals(element.getAmenity())) // Adjust as per your ApiResponse structure
//                .map(element -> new PoliceStationDTO(element.getId(), element.getName(), element.getAddress())) // Map to DTO
//                .collect(Collectors.toList());
//    }
//}
package com.SOS.service;

import com.SOS.domain.ApiResponse;
import com.SOS.dto.ElementDto;
import com.SOS.dto.HospitalDTO;
import com.SOS.dto.FireStationDTO;
import com.SOS.dto.PoliceStationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SOSService {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<HospitalDTO> getNearbyHospitals(double lat, double lon) {
        String query = "[out:json];node[\"amenity\"=\"hospital\"](around:5000," + lat + "," + lon + ");out;";
        String url = "https://overpass-api.de/api/interpreter?data=" + query;

        try {
            ResponseEntity<ApiResponse> response = restTemplate.getForEntity(url, ApiResponse.class);
            return mapHospitals(response.getBody());
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            return null; // Or handle this as appropriate
        }
    }

    public List<FireStationDTO> getNearbyFireStations(double lat, double lon) {
        String query = "[out:json];node[\"amenity\"=\"fire_station\"](around:5000," + lat + "," + lon + ");out;";
        String url = "https://overpass-api.de/api/interpreter?data=" + query;

        try {
            ResponseEntity<ApiResponse> response = restTemplate.getForEntity(url, ApiResponse.class);
            return mapFireStations(response.getBody());
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            return null; // Or handle this as appropriate
        }
    }

    public List<PoliceStationDTO> getNearbyPoliceStations(double lat, double lon) {
        String query = "[out:json];node[\"amenity\"=\"police\"](around:5000," + lat + "," + lon + ");out;";
        String url = "https://overpass-api.de/api/interpreter?data=" + query;

        try {
            ResponseEntity<ApiResponse> response = restTemplate.getForEntity(url, ApiResponse.class);
            return mapPoliceStations(response.getBody());
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            return null; // Or handle this as appropriate
        }
    }

    private List<HospitalDTO> mapHospitals(ApiResponse apiResponse) {
        return apiResponse.getElements().stream()
                .filter(element -> "hospital".equals(element.getTags().get("amenity"))) // Check the amenity tag
                .map(element -> new HospitalDTO(
                        element.getId(),
                        element.getTags().get("name"),
                        element.getTags().get("address"),
                        element.getLat(),
                        element.getLon()
                ))
                .collect(Collectors.toList());
    }

    private List<FireStationDTO> mapFireStations(ApiResponse apiResponse) {
        return apiResponse.getElements().stream()
                .filter(element -> "fire_station".equals(element.getTags().get("amenity"))) // Check the amenity tag
                .map(element -> new FireStationDTO(
                        element.getId(),
                        element.getTags().get("name"),
                        element.getTags().get("address"),
                        element.getLat(),
                        element.getLon()
                ))
                .collect(Collectors.toList());
    }

    private List<PoliceStationDTO> mapPoliceStations(ApiResponse apiResponse) {
        return apiResponse.getElements().stream()
                .filter(element -> "police".equals(element.getTags().get("amenity"))) // Check the amenity tag
                .map(element -> new PoliceStationDTO(
                        element.getId(),
                        element.getTags().get("name"),
                        element.getTags().get("address"),
                        element.getLat(),
                        element.getLon()
                ))
                .collect(Collectors.toList());
    }
}
