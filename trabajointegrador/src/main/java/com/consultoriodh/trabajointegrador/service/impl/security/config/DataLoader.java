package com.consultoriodh.trabajointegrador.service.impl.security.config;

import com.consultoriodh.trabajointegrador.repository.ApiUserRepository;
import com.consultoriodh.trabajointegrador.entity.ApiUser;
import com.consultoriodh.trabajointegrador.entity.ApiUserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private ApiUserRepository userRepository;


    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("123456");
        String hashedPassword1 = passwordEncoder.encode("123456");
        userRepository.save(new ApiUser("User", "pass", "userTest@digital.com",
                hashedPassword, ApiUserRoles.USER));
        userRepository.save(new ApiUser("Admin", "admin", "adminTest@digital.com", hashedPassword1, ApiUserRoles.ADMIN));
    }
}
