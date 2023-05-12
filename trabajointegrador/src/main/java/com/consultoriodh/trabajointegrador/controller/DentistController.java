package com.consultoriodh.trabajointegrador.controller;

import com.consultoriodh.trabajointegrador.dto.DentistDTO;
import com.consultoriodh.trabajointegrador.exceptions.ResourceNotFoundException;
import com.consultoriodh.trabajointegrador.service.impl.DentistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/dentist")
public class DentistController {

    @Autowired
    private DentistServiceImpl serviceDentistImpl;


    @GetMapping
    public Optional<DentistDTO> getDentistHandler(@RequestParam Integer id) throws ResourceNotFoundException {
        return serviceDentistImpl.searchDentist(id);
    }

    @GetMapping("/all")
    public List<DentistDTO> getAllDentistsHandler() {
        return serviceDentistImpl.searchAll();
    }

    @GetMapping(path = "/lastname/{name}")
    public Optional<DentistDTO> getDentistByLastNameHandler(@PathVariable String name) throws ResourceNotFoundException {
        return serviceDentistImpl.findDentistByLastName(name);
    }

    @GetMapping(path = "/id/{license}")
    public Optional<DentistDTO> getDentistByLastNameHandler(@PathVariable Integer license) throws ResourceNotFoundException {
        return serviceDentistImpl.findDentistByLicense(license);
    }

    @PostMapping
    public ResponseEntity<String> postDentistHandler(@RequestBody DentistDTO dentistDTO) {
        serviceDentistImpl.insertDentist(dentistDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Dentista agregado correctamente");
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteDentistHandler(@PathVariable Integer id) {
        serviceDentistImpl.deleteDentist(id);
        return ResponseEntity.status(HttpStatus.OK).body("Dentista eliminado correctamente");
    }

    @PutMapping
    public ResponseEntity<String> updateDentistHandler(@RequestParam Integer id, @RequestBody DentistDTO dentistDTO) {
        serviceDentistImpl.updateDentist(dentistDTO, id);
        return ResponseEntity.ok("Datos del dentista actualizados correctamente");
    }


}
