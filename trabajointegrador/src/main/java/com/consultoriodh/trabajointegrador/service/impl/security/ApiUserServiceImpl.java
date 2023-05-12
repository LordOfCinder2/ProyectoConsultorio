package com.consultoriodh.trabajointegrador.service.impl.security;


import com.consultoriodh.trabajointegrador.dto.UserDTO;
import com.consultoriodh.trabajointegrador.repository.ApiUserRepository;
import com.consultoriodh.trabajointegrador.entity.ApiUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ApiUserServiceImpl implements UserDetailsService {
    @Autowired
    ApiUserRepository apiUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return apiUserRepository.findByEmail(email).get();
    }
    public void insertUser(UserDTO userDTO){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        ObjectMapper objectMapper = new ObjectMapper();
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        ApiUser user = objectMapper.convertValue(userDTO, ApiUser.class);
        apiUserRepository.save(user);
    }
}
