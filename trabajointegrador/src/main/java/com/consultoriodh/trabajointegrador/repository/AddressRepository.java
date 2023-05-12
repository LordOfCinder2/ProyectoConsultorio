package com.consultoriodh.trabajointegrador.repository;

import com.consultoriodh.trabajointegrador.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
}
