package com.SOS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FireStationDTO {
    private long id;
    private String name;
    private String address;
    private double lat;
    private double lon;
}