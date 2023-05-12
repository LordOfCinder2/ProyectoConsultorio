package com.consultoriodh.trabajointegrador.service;

import com.consultoriodh.trabajointegrador.dto.AppointmentDTO;
import com.consultoriodh.trabajointegrador.exceptions.ResourceNotFoundException;
import com.consultoriodh.trabajointegrador.entity.Appointment;

import java.util.List;
import java.util.Optional;


public interface AppointmentService {
    Optional<AppointmentDTO> searchAppointment(Integer id) throws ResourceNotFoundException;
    List<AppointmentDTO> searchAll();
    void createAppointment(Appointment appointment);
    void deleteAppointment(Integer id);

    Integer totalAmountOfAppointments();
}
