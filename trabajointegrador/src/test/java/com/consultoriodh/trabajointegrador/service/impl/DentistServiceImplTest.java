package com.consultoriodh.trabajointegrador.service.impl;

import com.consultoriodh.trabajointegrador.dto.DentistDTO;
import com.consultoriodh.trabajointegrador.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DentistServiceImplTest {

        @Autowired
        private DentistServiceImpl dentistService;
    @Test
    @Transactional
    void testUpdateDentistInfo() throws ResourceNotFoundException {
        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setLastName("Man");
        dentistDTO.setFirstName("Power");
        dentistDTO.setLicense(13);
        dentistService.insertDentist(dentistDTO);

        DentistDTO dentistDTO1 = new DentistDTO();
        dentistDTO1.setFirstName("Hola");
        dentistDTO1.setLastName("Chau");
        dentistService.updateDentist(dentistDTO1,2);
        assertEquals("DentistDTO(id=2, lastName=Chau, firstName=Hola, license=13)",dentistService.searchDentist(2).get().toString());
    }
    @Test
    void testInsertDentist() throws ResourceNotFoundException {
        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setLastName("Ricky");
        dentistDTO.setFirstName("Martin");
        dentistDTO.setLicense(2);
        dentistService.insertDentist(dentistDTO);

        assertNotNull(dentistService.searchDentist(1));
    }
    @Test
    void testFindDentistByLicense() throws ResourceNotFoundException {
        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setLastName("Rogelio");
        dentistDTO.setFirstName("Aguas");
        dentistDTO.setLicense(5);
        dentistService.insertDentist(dentistDTO);

        assertNotNull(dentistService.findDentistByLicense(5));
    }

}