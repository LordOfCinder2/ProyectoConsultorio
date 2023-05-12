package com.consultoriodh.trabajointegrador.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect
public class DentistDTO {
    private Integer id;
    private String lastName;
    private String firstName;
    private Integer license;
}
