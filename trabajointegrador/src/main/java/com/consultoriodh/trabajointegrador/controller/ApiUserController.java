package com.consultoriodh.trabajointegrador.controller;

import com.consultoriodh.trabajointegrador.dto.UserDTO;
import com.consultoriodh.trabajointegrador.service.impl.security.ApiUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class ApiUserController {
    @Autowired
    private ApiUserServiceImpl apiUserService;

    @PostMapping("/postuser")
    public ResponseEntity<String> insertUser(@RequestBody UserDTO userDTO){
        apiUserService.insertUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado correctamente");
    }
}
