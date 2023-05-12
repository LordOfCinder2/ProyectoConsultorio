package com.consultoriodh.trabajointegrador.repository;

import com.consultoriodh.trabajointegrador.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    @Query("SELECT COUNT(a) FROM Appointment a")
    Integer totalAmountOfAppointments();
}
