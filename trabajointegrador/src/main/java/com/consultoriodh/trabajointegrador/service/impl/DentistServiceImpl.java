package com.consultoriodh.trabajointegrador.service.impl;


import com.consultoriodh.trabajointegrador.dto.DentistDTO;
import com.consultoriodh.trabajointegrador.repository.DentistRepository;
import com.consultoriodh.trabajointegrador.exceptions.ResourceNotFoundException;
import com.consultoriodh.trabajointegrador.entity.Dentist;
import com.consultoriodh.trabajointegrador.service.DentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class DentistServiceImpl implements DentistService {

    @Autowired
    private DentistRepository dentistRepository;

    private final static Logger log = LogManager.getFormatterLogger();
    @Override
    public Optional<DentistDTO> searchDentist(Integer id) throws ResourceNotFoundException {
        ObjectMapper objectMapper = new ObjectMapper();
        DentistDTO dentistDTO;
        Dentist dentist = null;
        Optional<Dentist> optionalDentist = dentistRepository.findById(id);
        if (optionalDentist.isPresent()) {
            dentist = optionalDentist.get();
        }else{
            log.error("el dentista no existe en la base de datos");
            throw new ResourceNotFoundException("El dentista no existe en la base de datos");
        }
        dentistDTO = objectMapper.convertValue(dentist, DentistDTO.class);
        log.info("Dentista encontrado correctamente");
        return Optional.of(dentistDTO);
    }

    @Override
    public List<DentistDTO> searchAll() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<DentistDTO> dentistDTOList = new ArrayList<>();
        List<Dentist> dentistList = dentistRepository.findAll();
        for (Dentist dentist : dentistList
        ) {
            dentistDTOList.add(objectMapper.convertValue(dentist, DentistDTO.class));
        }
        return dentistDTOList;
    }

    @Override
    public void insertDentist(DentistDTO dentistDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        Dentist dentist = objectMapper.convertValue(dentistDTO, Dentist.class);
        dentistRepository.save(dentist);
        log.info("Dentista agregado correctamente");
    }

    @Override
    public void deleteDentist(Integer id) {
        dentistRepository.deleteById(id);
        log.info("Dentista eliminado de la base de datos");
    }

    @Override
    public void updateDentist(DentistDTO dentistDTO, Integer id){
        ObjectMapper objectMapper = new ObjectMapper();
        Dentist dentist1 = dentistRepository.getReferenceById(id);
        Dentist dentist = objectMapper.convertValue(dentistDTO,Dentist.class);
        if(dentist.getFirstName()!=null)
            dentist1.setFirstName(dentist.getFirstName());
        if(dentist.getLastName()!=null)
            dentist1.setLastName(dentist.getLastName());
        if(dentist.getLicense()!=null)
            dentist1.setLicense(dentist.getLicense());
        dentistRepository.save(dentist1);

    }

    @Override
    public Optional<DentistDTO> findDentistByLastName(String name) throws ResourceNotFoundException {
        ObjectMapper objectMapper = new ObjectMapper();
        DentistDTO dentistDTO;
        Dentist dentist = null;
        Optional<Dentist> optionalDentist = dentistRepository.findByLastName(name);
        if (optionalDentist.isPresent()) {
            dentist = optionalDentist.get();
        }
        else{
            log.error("el dentista no existe en la base de datos");
            throw new ResourceNotFoundException("El dentista no existe en la base de datos");
        }
        dentistDTO = objectMapper.convertValue(dentist, DentistDTO.class);
        return Optional.of(dentistDTO);
    }

    @Override
    public Optional<DentistDTO> findDentistByLicense(Integer license) throws ResourceNotFoundException {
        ObjectMapper objectMapper = new ObjectMapper();
        DentistDTO dentistDTO;
        Dentist dentist = null;
        Optional<Dentist> optionalDentist = dentistRepository.findByLicense(license);
        if (optionalDentist.isPresent()) {
            dentist = optionalDentist.get();
        }
        else{
            log.error("el dentista no existe en la base de datos");
            throw new ResourceNotFoundException("El dentista no existe en la base de datos");
        }
        dentistDTO = objectMapper.convertValue(dentist, DentistDTO.class);
        return Optional.of(dentistDTO);
    }
}
