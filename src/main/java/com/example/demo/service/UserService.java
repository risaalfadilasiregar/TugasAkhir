package com.example.demo.service;

import com.example.demo.entity.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO findByUsername(String username);

    List<UserDTO> getAllData();
}
