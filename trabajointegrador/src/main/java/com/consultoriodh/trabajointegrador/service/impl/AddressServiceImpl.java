package com.consultoriodh.trabajointegrador.service.impl;

import com.consultoriodh.trabajointegrador.dto.AddressDTO;
import com.consultoriodh.trabajointegrador.entity.Address;
import com.consultoriodh.trabajointegrador.repository.AddressRepository;
import com.consultoriodh.trabajointegrador.service.AddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Override
    public void updateAddress(AddressDTO addressDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        addressRepository.save(objectMapper.convertValue(addressDTO, Address.class));
    }
}
