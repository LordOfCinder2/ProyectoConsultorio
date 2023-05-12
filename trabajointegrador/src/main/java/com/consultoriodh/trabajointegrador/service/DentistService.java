package com.consultoriodh.trabajointegrador.service;

import com.consultoriodh.trabajointegrador.dto.DentistDTO;
import com.consultoriodh.trabajointegrador.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DentistService {
    Optional<DentistDTO> searchDentist(Integer id) throws ResourceNotFoundException;
    List<DentistDTO> searchAll();
    void  insertDentist(DentistDTO dentistDTO);
    void deleteDentist(Integer id);

    void updateDentist(DentistDTO dentistDTO,Integer id);

    Optional<DentistDTO> findDentistByLastName(String name) throws ResourceNotFoundException;
    Optional<DentistDTO> findDentistByLicense(Integer license) throws ResourceNotFoundException;
}
