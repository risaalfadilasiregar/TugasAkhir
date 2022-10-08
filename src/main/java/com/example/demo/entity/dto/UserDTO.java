package com.example.demo.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
    private Long id_user;

    private String username;

    private String password;

    private String email;

    private String role;
}
