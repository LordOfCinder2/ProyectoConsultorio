package com.consultoriodh.trabajointegrador.service;

import com.consultoriodh.trabajointegrador.dto.AddressDTO;
import com.consultoriodh.trabajointegrador.dto.PatientDTO;
import com.consultoriodh.trabajointegrador.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    Optional<PatientDTO> searchPatient(Integer id) throws ResourceNotFoundException;
    List<PatientDTO> searchAll();
    void insertPatient(PatientDTO patient);
    void deletePatient(Integer id);
    Optional<PatientDTO> findPatientByIdentification(Integer id) throws ResourceNotFoundException;
    void updatePatientAddress(Integer id, AddressDTO addressDTO);

}
