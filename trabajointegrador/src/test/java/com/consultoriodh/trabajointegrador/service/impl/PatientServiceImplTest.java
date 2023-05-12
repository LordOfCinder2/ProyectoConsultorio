package com.consultoriodh.trabajointegrador.service.impl;

import com.consultoriodh.trabajointegrador.dto.AddressDTO;
import com.consultoriodh.trabajointegrador.dto.PatientDTO;
import com.consultoriodh.trabajointegrador.entity.Address;
import com.consultoriodh.trabajointegrador.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientServiceImplTest {
    @Autowired
    private PatientServiceImpl patientService;

    @Test
    void searchPatient() throws ResourceNotFoundException {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setLastName("Ricky");
        patientDTO.setFirstName("Martin");
        patientDTO.setIdentification(2);
        Address addressDTO = new Address();
        addressDTO.setCity("Bs As");
        addressDTO.setStreet("Calle Falsa 123");
        addressDTO.setCountry("Mongolia");
        patientDTO.setAddress(addressDTO);
        patientService.insertPatient(patientDTO);

        assertNotNull(patientService.findPatientByIdentification(2));
    }

    @Test
    @Transactional
    void updatePatientAddress() throws ResourceNotFoundException {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setLastName("Ricky");
        patientDTO.setFirstName("Martin");
        patientDTO.setIdentification(6);
        Address addressDTO = new Address();
        addressDTO.setCity("Bs As");
        addressDTO.setStreet("Calle Falsa 123");
        addressDTO.setCountry("Mongolia");
        patientDTO.setAddress(addressDTO);
        patientService.insertPatient(patientDTO);
        AddressDTO address = new AddressDTO();
        address.setCity("Cordoba");
        address.setStreet("Calle real 123");
        address.setCountry("Argentina");
        patientService.updatePatientAddress(1, address);

        assertEquals("Address(id=1, street=Calle real 123, city=Cordoba, country=Argentina, patient=null)", patientService.findPatientByIdentification(6).get().getAddress().toString());
    }
}