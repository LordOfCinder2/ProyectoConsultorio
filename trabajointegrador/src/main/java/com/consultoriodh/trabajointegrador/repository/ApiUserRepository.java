package com.consultoriodh.trabajointegrador.repository;

import com.consultoriodh.trabajointegrador.entity.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface ApiUserRepository extends JpaRepository<ApiUser,Integer> {

    Optional<ApiUser> findByUsername(String username);
    Optional<ApiUser> findByEmail(String email);
}
