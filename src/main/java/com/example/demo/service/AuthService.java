package com.example.demo.service;

import com.example.demo.entity.dto.AuthenticationDTO;
import com.example.demo.entity.dto.ResponseAuthDTO;
import com.example.demo.entity.dto.UserDTO;

public interface AuthService {

    ResponseAuthDTO register(UserDTO data);

    ResponseAuthDTO login(AuthenticationDTO data);
}
