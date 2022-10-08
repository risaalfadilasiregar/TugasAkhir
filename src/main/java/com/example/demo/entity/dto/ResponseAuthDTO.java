package com.example.demo.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseAuthDTO {
    private Long id;

    private String username;

    private String email;

    private String role;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String token;
}
