package com.SOS.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "SosDetails")
public class SosDetails {
    @Id
    private String userID;
    private String latitude;
    private String longitude;
    private String emergencyType;
}
