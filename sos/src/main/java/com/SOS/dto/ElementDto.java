package com.SOS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ElementDto {
    private String type;
    private long id;
    private double lat;
    private double lon;
    private Map<String, String> tags;
}
