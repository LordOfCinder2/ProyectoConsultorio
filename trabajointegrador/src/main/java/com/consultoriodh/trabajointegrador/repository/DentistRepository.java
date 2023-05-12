package com.consultoriodh.trabajointegrador.repository;

import com.consultoriodh.trabajointegrador.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Integer> {

    @Query("SELECT d FROM Dentist d WHERE d.lastName = ?1")
    Optional<Dentist> findByLastName(String name);

    @Query("SELECT d FROM Dentist d WHERE d.license = ?1")
    Optional<Dentist> findByLicense(Integer license);
}
