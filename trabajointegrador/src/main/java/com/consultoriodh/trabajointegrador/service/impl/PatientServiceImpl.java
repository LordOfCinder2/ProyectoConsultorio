package com.consultoriodh.trabajointegrador.service.impl;


import com.consultoriodh.trabajointegrador.dto.AddressDTO;
import com.consultoriodh.trabajointegrador.dto.PatientDTO;
import com.consultoriodh.trabajointegrador.repository.AddressRepository;
import com.consultoriodh.trabajointegrador.repository.PatientRepository;
import com.consultoriodh.trabajointegrador.exceptions.ResourceNotFoundException;
import com.consultoriodh.trabajointegrador.entity.Address;
import com.consultoriodh.trabajointegrador.entity.Patient;
import com.consultoriodh.trabajointegrador.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
   @Autowired
   private PatientRepository patientRepository;
   @Autowired
   private AddressRepository addressRepository;
   private final static Logger log = LogManager.getFormatterLogger();

@Override
   public Optional<PatientDTO> searchPatient(Integer id) throws ResourceNotFoundException {
      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.registerModule(new JavaTimeModule());
      PatientDTO patientDTO;
      Patient patient = null;
      Optional<Patient> optionalPatient = patientRepository.findById(id);
      if (optionalPatient.isPresent()) {
         patient = optionalPatient.get();
      }else {
         log.error("Paciente no encontrado en la base de datos");
         throw new ResourceNotFoundException("Paciente no existe en la base de datos");
      }
      patientDTO = objectMapper.convertValue(patient, PatientDTO.class);
      return Optional.of(patientDTO);
   }

   @Override
   public List<PatientDTO> searchAll(){
      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.registerModule(new JavaTimeModule());
      List<PatientDTO> patientDTOList = new ArrayList<>();
      List<Patient> patientList = patientRepository.findAll();
      for (Patient patient: patientList
      ) {
         patientDTOList.add(objectMapper.convertValue(patient,PatientDTO.class));
      }
      return patientDTOList;
   }

   @Override
   public void insertPatient(PatientDTO patient){
      ObjectMapper objectMapper = new ObjectMapper();
      patientRepository.save(objectMapper.convertValue(patient,Patient.class));
      log.info("Paciente agregado correctamente");
   }

   @Override
   public void deletePatient(Integer id){
      patientRepository.deleteById(id);
   }

   @Override
   public Optional<PatientDTO> findPatientByIdentification(Integer id) throws ResourceNotFoundException {
      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.registerModule(new JavaTimeModule());
      PatientDTO patientDTO;
      Patient patient = null;
      Optional<Patient> optionalPatient = patientRepository.findByIdentification(id);
      if (optionalPatient.isPresent()) {
         patient = optionalPatient.get();
      }else {
         log.error("Paciente no encontrado en la base de datos");
         throw new ResourceNotFoundException("Paciente no existe en la base de datos");
      }
      patientDTO = objectMapper.convertValue(patient, PatientDTO.class);
      return Optional.of(patientDTO);
   }

   @Override
   public void updatePatientAddress(Integer id, AddressDTO addressDTO) {
      ObjectMapper objectMapper = new ObjectMapper();
      Patient patient1 = patientRepository.getReferenceById(id);
      Address address = objectMapper.convertValue(addressDTO,Address.class);
      Address address1 = addressRepository.getReferenceById(patient1.getAddress().getId());
      address1.setCity(address.getCity());
      address1.setCountry(address.getCountry());
      address1.setStreet(address.getStreet());
      addressRepository.save(address1);
      log.info("Direccion actualizada correctamente");
   }
}
