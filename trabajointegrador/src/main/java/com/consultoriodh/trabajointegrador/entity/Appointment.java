package com.consultoriodh.trabajointegrador.entity;




import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;
    @ManyToOne
    @JoinColumn(name = "dentist_id", nullable = false)
    private Dentist dentist;
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
    @Column(name = "appointment_date")
    private LocalDate appointmentDate;
    @Column(name = "appointment_time")
    private LocalTime appointmentTime;

}
