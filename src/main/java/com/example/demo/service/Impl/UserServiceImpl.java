package com.example.demo.service.Impl;

import com.example.demo.entity.dto.UserDTO;
import com.example.demo.entity.mapping.UserMapping;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDTO findByUsername(String username) {
        return UserMapping.instance.toDto(repository.findByUsername(username));
    }

    @Override
    public List<UserDTO> getAllData() {
        return UserMapping.instance.toListDto(repository.findAll());
    }
}
