package com.consultoriodh.trabajointegrador.controller;

import com.consultoriodh.trabajointegrador.dto.AddressDTO;
import com.consultoriodh.trabajointegrador.dto.PatientDTO;
import com.consultoriodh.trabajointegrador.exceptions.ResourceNotFoundException;
import com.consultoriodh.trabajointegrador.service.impl.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientServiceImpl servicePatientImpl;

    @GetMapping
    public Optional<PatientDTO> getPatientHandler(@RequestParam Integer id) throws ResourceNotFoundException {
        return servicePatientImpl.searchPatient(id);
    }

    @GetMapping("/all")
    public List<PatientDTO> searchAll(){
        return servicePatientImpl.searchAll();
    }

    @GetMapping("{license}")
    public Optional<PatientDTO> getPatientByIdentificationHandler(@PathVariable Integer license) throws ResourceNotFoundException {
        return servicePatientImpl.findPatientByIdentification(license);
    }

    @PostMapping
    public ResponseEntity<String> insertPatient(@RequestBody PatientDTO patient){
        servicePatientImpl.insertPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body("Paciente creado correctamente");
    }

    @PutMapping
    public void updatePatientAddress(@RequestParam Integer id, @RequestBody AddressDTO addressDTO){
        servicePatientImpl.updatePatientAddress(id, addressDTO);
    }
    @DeleteMapping
    public ResponseEntity<String> deletePatient(Integer id){
        servicePatientImpl.deletePatient(id);
        return ResponseEntity.ok("Paciente eliminado correctamente");
    }
}
