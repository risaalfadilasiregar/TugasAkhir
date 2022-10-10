package com.example.demo.service.Impl;

import com.example.demo.entity.User;
import com.example.demo.entity.dto.AuthenticationDTO;
import com.example.demo.entity.dto.ResponseAuthDTO;
import com.example.demo.entity.dto.UserDTO;
import com.example.demo.entity.mapping.UserMapping;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;



@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository repository;



    @Override
    public ResponseAuthDTO register(UserDTO data) {
        User user = UserMapping.instance.toEntity(data);
        user.setPassword(BCrypt.hashpw(data.getPassword(), BCrypt.gensalt()));

        user = repository.save(user);

        return UserMapping.instance.fromEntityToResponseDto(user);
    }

    @Override
    public ResponseAuthDTO login(AuthenticationDTO data) {
        return null;
    }
}
