package com.example.demo.service.Impl;

import com.example.demo.config.JwtTokenUtil;
import com.example.demo.entity.User;
import com.example.demo.entity.dto.AuthenticationDTO;
import com.example.demo.entity.dto.ResponseAuthDTO;
import com.example.demo.entity.dto.UserDTO;
import com.example.demo.entity.mapping.UserMapping;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository repository;


    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public ResponseAuthDTO register(UserDTO data) {
        User user = UserMapping.instance.toEntity(data);
        user.setPassword(BCrypt.hashpw(data.getPassword(), BCrypt.gensalt()));

        user = repository.save(user);

        return UserMapping.instance.fromEntityToResponseDto(user);

    }

    @Override
    public ResponseAuthDTO login(AuthenticationDTO data) {

        com.example.demo.entity.User currentUser = repository.findByUsername(data.getUsername());

        ResponseAuthDTO res = UserMapping.instance.fromEntityToResponseDto(currentUser);

        if (currentUser == null){
            return null;
        } else if (currentUser.getPassword() != null && BCrypt.checkpw(data.getPassword(), currentUser.getPassword())) {
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(currentUser.getUsername(), currentUser.getPassword(), new ArrayList<>());

            res.setToken(jwtTokenUtil.doGenerateToken(userDetails));

            return res;
        }

        return null;
    }
    
}
