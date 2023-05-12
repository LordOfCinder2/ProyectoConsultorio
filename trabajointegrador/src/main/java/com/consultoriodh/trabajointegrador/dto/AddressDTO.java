package com.consultoriodh.trabajointegrador.dto;

import com.consultoriodh.trabajointegrador.entity.Patient;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect
public class AddressDTO {
    private String street;
    private String city;
    private String country;
    private Patient patient;
}
