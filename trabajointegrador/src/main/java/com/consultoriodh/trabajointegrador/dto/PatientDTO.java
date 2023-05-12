package com.consultoriodh.trabajointegrador.dto;

import com.consultoriodh.trabajointegrador.entity.Address;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect
public class PatientDTO {
    private String lastName;
    private String firstName;
    private Integer identification;
    private Address address;
}
