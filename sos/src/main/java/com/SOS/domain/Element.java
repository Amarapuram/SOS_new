package com.SOS.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Element {
    private String type;
    private long id;
    private double lat;
    private double lon;
    private Map<String, String> tags;

    // Getters and Setters

//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public double getLat() {
//        return lat;
//    }
//
//    public void setLat(double lat) {
//        this.lat = lat;
//    }
//
//    public double getLon() {
//        return lon;
//    }
//
//    public void setLon(double lon) {
//        this.lon = lon;
//    }
//
//    public Map<String, String> getTags() {
//        return tags;
//    }
//
//    public void setTags(Map<String, String> tags) {
//        this.tags = tags;
//    }
//}
}