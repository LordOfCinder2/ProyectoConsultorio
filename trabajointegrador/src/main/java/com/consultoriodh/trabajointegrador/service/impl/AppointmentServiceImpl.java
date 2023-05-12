package com.consultoriodh.trabajointegrador.service.impl;

import com.consultoriodh.trabajointegrador.dto.AppointmentDTO;
import com.consultoriodh.trabajointegrador.repository.AppointmentRepository;
import com.consultoriodh.trabajointegrador.exceptions.ResourceNotFoundException;
import com.consultoriodh.trabajointegrador.entity.Appointment;
import com.consultoriodh.trabajointegrador.repository.DentistRepository;
import com.consultoriodh.trabajointegrador.repository.PatientRepository;
import com.consultoriodh.trabajointegrador.service.AppointmentService;
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
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DentistRepository dentistRepository;
    private final static Logger log = LogManager.getFormatterLogger();
    @Override
    public Optional<AppointmentDTO> searchAppointment(Integer id) throws ResourceNotFoundException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        AppointmentDTO appointmentDTO;
        Appointment appointment = null;
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
        if (optionalAppointment.isPresent()) {
            appointment = optionalAppointment.get();
        }else {
            log.error("El turno no existe en la base de datos");
            throw new ResourceNotFoundException("El turno no existe");
        }
        appointmentDTO = objectMapper.convertValue(appointment, AppointmentDTO.class);
        return Optional.of(appointmentDTO);
    }

    @Override
    public List<AppointmentDTO> searchAll() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        List<AppointmentDTO> appointmentDTOList = new ArrayList<>();
        List<Appointment> appointmentList = appointmentRepository.findAll();
        for (Appointment appointment : appointmentList
        ) {
            appointmentDTOList.add(objectMapper.convertValue(appointment, AppointmentDTO.class));
        }
        return appointmentDTOList;
    }

    @Override
    public void createAppointment(Appointment appointment) {
        System.out.println(appointment.toString());
        patientRepository.save(appointment.getPatient());
        dentistRepository.save(appointment.getDentist());
        appointmentRepository.save(appointment);
        log.info("Se creo un nuevo turno");
    }

    @Override
    public void deleteAppointment(Integer id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public Integer totalAmountOfAppointments() {
        return appointmentRepository.totalAmountOfAppointments();
    }
}
