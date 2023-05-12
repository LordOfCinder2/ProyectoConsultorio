package com.consultoriodh.trabajointegrador.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="dentists")
public class Dentist {
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer license;
    @OneToMany(mappedBy = "dentist", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Appointment> appointmentSet = new HashSet<>();

    @Override
    public String toString() {
        return "Apellido: " + lastName +
                " | Nombre: " + firstName +
                " | Matricula: " + license;
    }


}
