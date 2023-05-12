package com.consultoriodh.trabajointegrador.dto;


import com.consultoriodh.trabajointegrador.entity.Dentist;
import com.consultoriodh.trabajointegrador.entity.Patient;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect
public class AppointmentDTO {
    private Dentist dentist;
    private Patient patient;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
}
