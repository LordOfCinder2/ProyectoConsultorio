package com.consultoriodh.trabajointegrador.controller;

import com.consultoriodh.trabajointegrador.dto.AppointmentDTO;
import com.consultoriodh.trabajointegrador.exceptions.ResourceNotFoundException;
import com.consultoriodh.trabajointegrador.entity.Appointment;
import com.consultoriodh.trabajointegrador.service.impl.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentServiceImpl serviceAppointmentImpl;


    @GetMapping
    public Optional<AppointmentDTO> getAppointmentHandler(@RequestParam Integer id) throws ResourceNotFoundException {
        return serviceAppointmentImpl.searchAppointment(id);
    }

    @GetMapping("/all")
    public List<AppointmentDTO> getAllAppointmentsHandler() {
        return serviceAppointmentImpl.searchAll();
    }

    @PostMapping
    public ResponseEntity<String> postAppointmentHandler(@RequestBody Appointment appointment) {
        serviceAppointmentImpl.createAppointment(appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body("Turno creado correctamente");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAppointmentHandler(@RequestParam Integer id) {
        serviceAppointmentImpl.deleteAppointment(id);
        return ResponseEntity.ok("Appointmenta eliminado correctamente");
    }
    @GetMapping("/count")
    public ResponseEntity<String> totalCountOfAppointment(){
        return ResponseEntity.status(HttpStatus.OK).body("La cantidad de turnos registrados en la base de datos es: "+serviceAppointmentImpl.totalAmountOfAppointments());
    }
}
