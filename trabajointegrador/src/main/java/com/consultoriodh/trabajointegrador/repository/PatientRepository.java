package com.consultoriodh.trabajointegrador.repository;

import com.consultoriodh.trabajointegrador.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    @Query("SELECT p FROM Patient p WHERE p.identification = ?1")
    Optional<Patient> findByIdentification(Integer identification);
}
